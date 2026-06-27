package com.pdv.maxmillian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pdv.maxmillian.dto.ProdutoRequest;
import com.pdv.maxmillian.dto.ProdutoResponse;
import com.pdv.maxmillian.entity.Categoria;
import com.pdv.maxmillian.entity.Produto;
import com.pdv.maxmillian.mapper.ProdutoMapper;
import com.pdv.maxmillian.repository.CategoriaRepository;
import com.pdv.maxmillian.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoResponse cadastrarProduto(ProdutoRequest produtoRequest) {
        
        // Não permitir código de barras duplicado.
        if (produtoRepository.existsByCodigoBarras(produtoRequest.codigoBarras())) {
            throw new IllegalArgumentException("Produto ja cadastrado");
        }

        // falta valdar comparação entre preço e venda
        if (produtoRequest.precoVenda().compareTo(produtoRequest.precoCompra()) < 0) {
            throw new IllegalArgumentException("Produto com preço de venda errado");
        }

        Categoria categoria = categoriaRepository.findById(produtoRequest.categoriaId())
                    .orElseThrow(() -> 
                            new IllegalArgumentException("Categoria não encontrada"));

        Produto produto = ProdutoMapper.toEntity(produtoRequest);
        produto.setCategoria(categoria);
        produto.setAtivo(true);

        Produto produtoSalvo = produtoRepository.save(produto);        

        return ProdutoMapper.toResponse(produtoSalvo);
    }

    public ProdutoResponse buscarProdutoPorId(Long id) {

        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> 
                    new IllegalArgumentException("Produto não encontrado"));
        
        return ProdutoMapper.toResponse(produto);

    }

    // Não está funcionando
    public List<ProdutoResponse> buscarProdutoPorNome(String nome) {

        return produtoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(ProdutoMapper::toResponse)
                .toList();

    }

    public List<ProdutoResponse> buscarTodosOsProdutos() {
        
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoMapper::toResponse)
                .toList();
    }
    
}
