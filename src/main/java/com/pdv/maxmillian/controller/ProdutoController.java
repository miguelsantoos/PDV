package com.pdv.maxmillian.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdv.maxmillian.dto.ProdutoRequest;
import com.pdv.maxmillian.dto.ProdutoResponse;
import com.pdv.maxmillian.service.ProdutoService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Recebe os dados
    @PostMapping
    public ProdutoResponse cadastrarProduto(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.cadastrarProduto(produtoRequest);
    }

    // Busca produto
    @GetMapping("/{id}")
    public ProdutoResponse buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @GetMapping("/buscar")
    public List<ProdutoResponse> buscarProdutoPorNome(@RequestBody String nome) {
        return produtoService.buscarProdutoPorNome(nome);
    }

    @GetMapping
    public List<ProdutoResponse> buscarTodosOsProdutos() {
        return produtoService.buscarTodosOsProdutos();
    }

}
