package com.pdv.maxmillian.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.pdv.maxmillian.dto.ItemVendaRequest;
import com.pdv.maxmillian.dto.VendaRequest;
import com.pdv.maxmillian.dto.VendaResponse;
import com.pdv.maxmillian.entity.ItemVenda;
import com.pdv.maxmillian.entity.Produto;
import com.pdv.maxmillian.entity.Venda;
import com.pdv.maxmillian.mapper.VendaMapper;
import com.pdv.maxmillian.repository.ItemVendaRepository;
import com.pdv.maxmillian.repository.ProdutoRepository;
import com.pdv.maxmillian.repository.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoRepository produtoRepository;

    public VendaService(VendaRepository vendaRepository,ItemVendaRepository itemVendaRepository ,ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.itemVendaRepository = itemVendaRepository;
        this.produtoRepository = produtoRepository;
    }


    public VendaResponse salvarVenda(VendaRequest vendaRequest) {

        Venda venda = new Venda();
        venda.setDataVenda(LocalDateTime.now());
        venda.setFormaPagamento(vendaRequest.formaPagamento());
        BigDecimal valorTotal = BigDecimal.ZERO;

        List<ItemVenda> itensVenda = new ArrayList<>();

        for(ItemVendaRequest itemVendaRequest : vendaRequest.itens()) {
            Produto produto = produtoRepository.findById(itemVendaRequest.produtoId()).orElseThrow(() ->  new IllegalArgumentException("erro"));
        
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produto);
        itemVenda.setPreçoUnitario(produto.getPrecoVenda());
        itemVenda.setQuantidade(itemVendaRequest.quantidade());
        itemVenda.setSubTotal(itemVenda.getPreçoUnitario().multiply(BigDecimal.valueOf(itemVenda.getQuantidade())));

        valorTotal.add(itemVenda.getSubTotal());
        itensVenda.add(itemVenda);
        }

        venda.setItemVenda(itensVenda);
        venda.setValorTotal(valorTotal);

        Venda vendaSalva = vendaRepository.save(venda);
        return VendaMapper.toResponse(vendaSalva);
    }

    /*

    public VendaResponse salvarVenda(VendaRequest vendaRequest) {
        
        Venda venda = new Venda();
        venda.setDataVenda(LocalDateTime.now());
        venda.setFormaPagamento(vendaRequest.formaPagamento());
        BigDecimal valorTotal = BigDecimal.ZERO;

        List<ItemVenda> itensVenda = new ArrayList<>();

        for (ItemVendaRequest itemVendaRequest : vendaRequest.itens()) {
             Produto produto = produtoRepository.findById(itemVendaRequest.produtoId()).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));     


            if (produto.getQuantidadeEstoque() < itemVendaRequest.quatidade()) {
                throw new IllegalArgumentException("Quantidade no estoque não é suficiente");
            }


            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setVenda(venda);
            itemVenda.setPreçoUnitario(produto.getPrecoVenda());
            itemVenda.setQuantidade(itemVendaRequest.quatidade());
            BigDecimal subTotal = itemVenda.getPreçoUnitario().multiply(BigDecimal.valueOf(itemVenda.getQuantidade()));
            itemVenda.setSubTotal(subTotal);

            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque()-itemVendaRequest.quatidade());

            valorTotal.add(subTotal);
            
            itensVenda.add(itemVenda);
        }   

         
        venda.setItemVenda(itensVenda);
        venda.setValorTotal(valorTotal);

        Venda vendaSalva = vendaRepository.save(venda);
        return VendaMapper.toResponse(vendaSalva);
        
    }
 */

    
}
