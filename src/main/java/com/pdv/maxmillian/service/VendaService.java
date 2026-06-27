package com.pdv.maxmillian.service;

import org.springframework.stereotype.Service;

import com.pdv.maxmillian.entity.Venda;
import com.pdv.maxmillian.repository.VendaRepository;

@Service
public class VendaService {

        private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }
    
}
