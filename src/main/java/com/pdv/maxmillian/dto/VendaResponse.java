package com.pdv.maxmillian.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.pdv.maxmillian.entity.FormaPagamento;

public record VendaResponse(
    Long id,
    FormaPagamento formaPagameto,
    LocalDateTime dataVenda,
    BigDecimal valorTotal,
    List<ItemVendaResponse> itens
    
) {
    
}
