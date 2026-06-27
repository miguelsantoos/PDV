package com.pdv.maxmillian.controller;

import org.springframework.web.bind.annotation.*;

import com.pdv.maxmillian.entity.Venda;
import com.pdv.maxmillian.service.VendaService;

@RequestMapping("/vendas")
@RestController
public class VendaController {

    private final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public Venda salvarVenda(@RequestBody Venda venda) {
        return vendaService.salvarVenda(venda);
    }
    
}
