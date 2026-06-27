package com.pdv.maxmillian.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.pdv.maxmillian.repository.CategoriaRepository;
import com.pdv.maxmillian.repository.ProdutoRepository;

@SpringBootTest
public class ProdutoServiceTest {

    @MockitoBean
    private ProdutoRepository produtoRepository;

    @MockitoBean
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoService produtoService;

    @Test
    void testCadastrarProduto() {

    }
}
