package com.antony.comics.mapper;

import com.antony.comics.dto.ComicDTO;
import com.antony.comics.dto.UsuarioDTO;
import com.antony.comics.entity.ComicEntity;
import com.antony.comics.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {
    public static UsuarioDTO toDto(UsuarioEntity entity){
        var dto = new UsuarioDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getDataNascimento()
        );
        if(entity.getComics() != null) {
            List<ComicDTO> comicDTOList = new ArrayList<>();
            entity.getComics().forEach(comicEntity ->{
                comicDTOList.add(ComicMapper.toDto(comicEntity));
            });
            dto.setComics(comicDTOList);
        }
        return dto;
    }
    public static UsuarioEntity toEntity(UsuarioDTO dto) {
        var entity = new UsuarioEntity(
                dto.getId(),
                dto.getNome(),
                dto.getEmail(),
                dto.getCpf(),
                dto.getDataNascimento()
        );
        if(dto.getComics() != null) {
            List<ComicEntity> comicEntityList = new ArrayList<>();
            dto.getComics().forEach(comicDTO -> {
                comicEntityList.add(ComicMapper.toEntity(comicDTO));
            });
            entity.setComics(comicEntityList);
        }
        return entity;
    }
}
