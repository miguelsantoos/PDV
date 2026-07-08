package com.pdv.maxmillian.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pdv.maxmillian.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;


    /**
     * InnerProdutoServiceTest
     */
    public class InnerProdutoServiceTest {
    
        @Test
        @DisplayName("Deve cadastrar um produto com sucesso")
        public void deveCadastrarProdutoComSucesso(){
            
        }
    }
}
