package com.pdv.maxmillian.dto;

import java.math.BigDecimal;


public record ProdutoRequest(

    String codigoBarras,

    String nome,

    String descricao,

    BigDecimal precoCompra,

    BigDecimal precoVenda,

    Integer quantidadeEstoque,

    Boolean ativo,

    Long categoriaId

) {
    
}
