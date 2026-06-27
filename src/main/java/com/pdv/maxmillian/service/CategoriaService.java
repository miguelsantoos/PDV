package com.pdv.maxmillian.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pdv.maxmillian.dto.CategoriaRequest;
import com.pdv.maxmillian.dto.CategoriaResponse;
import com.pdv.maxmillian.entity.Categoria;
import com.pdv.maxmillian.mapper.CategoriaMapper;
import com.pdv.maxmillian.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }


    // Salva no bando de dados
    public CategoriaResponse salvarCategoria(CategoriaRequest categoriaRequest) {

        if(categoriaRepository.existsByNomeIgnoreCase(categoriaRequest.nome())){
            throw new IllegalArgumentException("Categoria ja existente");
        }

        Categoria categoria = categoriaRepository.save(CategoriaMapper.toEntity(categoriaRequest));

        return CategoriaMapper.toResponse(categoria);
    }


    // Pesquisa todas as categorias
    public List<CategoriaResponse> listarCategorias() {
        
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaMapper::toResponse)
                .toList();
    
    }


    // Pesquisa por id
    public CategoriaResponse buscarCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        return CategoriaMapper.toResponse(categoria);        
                
    }

    // Deletar categoria
    public void deletarCategoria(Long id) {
        
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }

        Categoria categoria = categoriaRepository.findById(id)
                    .orElseThrow(() -> 
                        new IllegalArgumentException("Categoria nao econtrada"));

        if (!categoria.getProdutos().isEmpty()) {
            throw new IllegalArgumentException("Essa categoria cotem produtos ativos");
        }

        categoriaRepository.deleteById(id);
    }


    
}
