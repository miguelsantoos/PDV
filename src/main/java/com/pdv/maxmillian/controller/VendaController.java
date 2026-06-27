package com.pdv.maxmillian.controller;

import org.springframework.web.bind.annotation.*;

import com.pdv.maxmillian.dto.ProdutoRequest;
import com.pdv.maxmillian.dto.ProdutoResponse;
import com.pdv.maxmillian.dto.VendaRequest;
import com.pdv.maxmillian.dto.VendaResponse;
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
    public VendaResponse salvarVenda(@RequestBody VendaRequest vendaRequest) {
        return vendaService.salvarVenda(vendaRequest);
    }
    
}
