package com.pdv.maxmillian.mapper;


import com.pdv.maxmillian.dto.ItemVendaResponse;
import com.pdv.maxmillian.entity.ItemVenda;

public class ItemVendaMapper {
    
    public static ItemVendaResponse toResponse(ItemVenda itemVenda) {
        
        return new ItemVendaResponse(
            itemVenda.getProduto().getNome(),
            itemVenda.getQuantidade(),
            itemVenda.getPreçoUnitario(),
            itemVenda.getSubTotal()
        );
    }
}
