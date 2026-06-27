package com.pdv.maxmillian.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.maxmillian.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNomeIgnoreCase(String nome);
    
}
