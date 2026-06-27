package com.pdv.maxmillian.dto;

import java.math.BigDecimal;

public record ProdutoResponse(
    Long id,
    String codigoBarras,
    String nome,
    String descricao,
    BigDecimal precoVenda,
    Integer quantidadeEstoque,
    Boolean ativo,
    String categoria
) {
    
}
