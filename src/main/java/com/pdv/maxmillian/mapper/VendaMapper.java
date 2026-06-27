package com.pdv.maxmillian.mapper;


import com.pdv.maxmillian.dto.VendaResponse;
import com.pdv.maxmillian.entity.Venda;

public class VendaMapper {
    
    public static VendaResponse toResponse(Venda venda) {

        return new VendaResponse(
            venda.getId(),
            venda.getFormaPagamento(),
            venda.getDataVenda(),
            venda.getValorTotal(),
            venda.getItemVenda().stream().map(ItemVendaMapper::toResponse).toList()
        );
    }
}
