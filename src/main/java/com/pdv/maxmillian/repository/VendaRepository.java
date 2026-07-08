package com.pdv.maxmillian.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdv.maxmillian.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataVendaBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
    
}
