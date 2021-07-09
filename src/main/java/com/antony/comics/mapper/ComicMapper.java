package com.antony.comics.mapper;

import com.antony.comics.dto.ComicDTO;
import com.antony.comics.entity.ComicEntity;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComicMapper {
    public static ComicDTO toDto(ComicEntity entity) {
        return new ComicDTO(
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
                null,
                dto.getTitulo(),
                dto.getPreco(),
                dto.getAutores(),
                dto.getIsbn(),
                dto.getDescricao(),
                dto.getDiaDesconto(),
                dto.isDescontoAtivo()
        );
    }

    public static ComicEntity jsonToEntity(String json) {
        ComicEntity entity = new ComicEntity();
        JSONObject retornoJson = new JSONObject(json);
        JSONObject comics = new JSONObject(retornoJson.getJSONObject("data").getJSONArray("results").getJSONObject(0).toString());
        JSONArray jsonArrayAutores = comics.getJSONObject("creators").getJSONArray("items");
        entity.setId(comics.getInt("id"));
        entity.setTitulo(comics.getString("title"));
        entity.setPreco(comics.getJSONArray("prices").getJSONObject(0).getDouble("price"));
        entity.setIsbn(comics.getString("isbn"));
        entity.setDescricao(comics.getString("description"));
        StringBuilder stringAutores = new StringBuilder();
        for (int i = 0; i < jsonArrayAutores.length(); i++) {
            JSONObject autorJson = new JSONObject(jsonArrayAutores.getJSONObject(i).toString());
            stringAutores.append(autorJson.getString("name")).append(", ");
        }
        entity.setAutores(stringAutores.toString());
        return entity;
    }

}
