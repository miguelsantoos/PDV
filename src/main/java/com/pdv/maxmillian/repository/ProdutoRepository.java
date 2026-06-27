package com.pdv.maxmillian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pdv.maxmillian.entity.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    Produto findByNome(String nome);
    boolean existsByCodigoBarras(String codigoBarras);
    boolean existsByNome(String nome);
}
