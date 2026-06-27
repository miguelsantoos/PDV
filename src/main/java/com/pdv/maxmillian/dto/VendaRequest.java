package com.pdv.maxmillian.dto;

import java.util.List;

import com.pdv.maxmillian.entity.FormaPagamento;

public record VendaRequest(
    FormaPagamento formaPagamento,
    List<ItemVendaRequest> itens
) {
}
