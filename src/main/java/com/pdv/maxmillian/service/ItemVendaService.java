package com.pdv.maxmillian.service;


import com.pdv.maxmillian.repository.ItemVendaRepository;

public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

}
