package com.pdv.maxmillian.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
/*import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;*/
import lombok.*;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigoBarras;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String descricao;
    
    @Column(nullable = false)
    private BigDecimal precoCompra;

    @Column(nullable = false)
    private BigDecimal precoVenda;

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    @Column(nullable = false)
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
