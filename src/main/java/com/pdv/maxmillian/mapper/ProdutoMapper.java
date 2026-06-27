package com.pdv.maxmillian.mapper;

import com.pdv.maxmillian.dto.ProdutoRequest;
import com.pdv.maxmillian.dto.ProdutoResponse;
import com.pdv.maxmillian.entity.Produto;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequest produtoRequest){

        Produto produto = new Produto();

        produto.setCodigoBarras(produtoRequest.codigoBarras());
        produto.setNome(produtoRequest.nome());
        produto.setDescricao(produtoRequest.descricao());
        produto.setPrecoCompra(produtoRequest.precoCompra());
        produto.setPrecoVenda(produtoRequest.precoVenda());
        produto.setQuantidadeEstoque(produtoRequest.quantidadeEstoque());

        return produto;
    }

    public static ProdutoResponse toResponse(Produto produto) {
        
        return new ProdutoResponse(
            produto.getId(),
            produto.getCodigoBarras(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPrecoVenda(),
            produto.getQuantidadeEstoque(),
            produto.getAtivo(),
            produto.getCategoria().getNome()
        );
    }
}
