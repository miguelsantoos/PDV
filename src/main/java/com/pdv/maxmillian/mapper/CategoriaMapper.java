package com.pdv.maxmillian.mapper;

import com.pdv.maxmillian.dto.CategoriaRequest;
import com.pdv.maxmillian.dto.CategoriaResponse;
import com.pdv.maxmillian.entity.Categoria;

public class CategoriaMapper {
    
    public static Categoria toEntity(CategoriaRequest categoriaRequest) {

        Categoria categoria = new Categoria();
        categoria.setNome(categoriaRequest.nome());

        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria categoria) {

        return new CategoriaResponse(
            categoria.getNome(),
            categoria.getId()
        ); 
            
        
    }


}
