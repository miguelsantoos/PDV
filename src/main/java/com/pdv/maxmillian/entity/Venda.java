package com.pdv.maxmillian.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataVenda;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)    
    @Column(nullable = false)
    private FormaPagamento formaPagamento;

    @OneToMany(mappedBy = "venda",
                cascade = CascadeType.ALL)
    private List<ItemVenda> itemVenda;

}
