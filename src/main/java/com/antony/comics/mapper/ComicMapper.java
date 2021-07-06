package com.antony.comics.mapper;

import com.antony.comics.dto.ComicDTO;
import com.antony.comics.entity.ComicEntity;

public class ComicMapper {
    public static ComicDTO toDto(ComicEntity entity) {
        return new ComicDTO(
                entity.getId(),
                entity.getTitulo(),
                entity.getPreco(),
                entity.getAutores(),
                entity.getIsbn(),
                entity.getDescricao(),
                entity.getDiaDesconto(),
                entity.isDescontoAtivo()
        );
    }

    public static ComicEntity toEntity(ComicDTO dto) {
        return new ComicEntity(
                dto.getId(),
                dto.getTitulo(),
                dto.getPreco(),
                dto.getAutores(),
                dto.getIsbn(),
                dto.getDescricao(),
                dto.getDiaDesconto(),
                dto.isDescontoAtivo()
        );
    }

}
