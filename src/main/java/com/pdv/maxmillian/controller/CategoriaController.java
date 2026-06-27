package com.pdv.maxmillian.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.maxmillian.dto.CategoriaRequest;
import com.pdv.maxmillian.dto.CategoriaResponse;
import com.pdv.maxmillian.service.CategoriaService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaResponse salvarCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        return categoriaService.salvarCategoria(categoriaRequest);
    }

    @GetMapping
    public List<CategoriaResponse> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaResponse buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
    }
    
    
}
