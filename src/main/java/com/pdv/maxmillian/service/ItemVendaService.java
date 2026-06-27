package com.pdv.maxmillian.service;



import org.springframework.stereotype.Service;

import com.pdv.maxmillian.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }


}
