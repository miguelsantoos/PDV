package com.pdv.maxmillian.dto;

import java.math.BigDecimal;


public record ItemVendaResponse(
    String produto,
    Integer quantidade,
    BigDecimal precoUntario,
    BigDecimal subTotal
) {
    
}
