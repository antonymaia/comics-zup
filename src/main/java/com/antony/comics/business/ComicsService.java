package com.antony.comics.business;

import com.antony.comics.business.exception.ObjectNotFoundException;
import com.antony.comics.business.exception.ObjetoJaCadastradoException;
import com.antony.comics.client.MarvelClient;
import com.antony.comics.entity.ComicEntity;
import com.antony.comics.entity.UsuarioEntity;
import com.antony.comics.repository.ComicsRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class ComicsService {
    @Autowired
    private MarvelClient marvelClient;
    @Autowired
    private ComicsRepository repository;
    @Autowired
    UsuarioService usuarioService;

    @Value("${publicApiKey}")
    private String publicApiKey;
    @Value("${privateApiKey}")
    private String privateApiKey;
    Long dataHoraAtual = System.currentTimeMillis();

    public ComicEntity cadastrar(Integer id) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if(repository.findById(id).isPresent()){
            throw new ObjetoJaCadastradoException("Comic de ID: "+ id +" já cadastrado");
        }
        String jsonComic = marvelClient.buscarComics(id, dataHoraAtual.toString(),
                publicApiKey, gerarHash());
        ComicEntity entity = jsonToEntity(jsonComic);
        if(!entity.getIsbn().equals("")) {
            entity.setDiaDesconto(diaDesconto(entity.getIsbn()));
        }
        return repository.save(entity);
    }

    public void cadastrarComicDoUsuario(Integer idUsuario, Integer idComic) {
        UsuarioEntity usuarioEntity = usuarioService.buscar(idUsuario);
        ComicEntity comicEntity = buscar(idComic);
        repository.cadastrarComicDoUsuario(idUsuario, idComic);
    }

    private ComicEntity buscar(Integer idComic) {
        Optional<ComicEntity> entity = repository.findById(idComic);
        return entity.orElseThrow(() -> new ObjectNotFoundException(" Comic não encontrado: ID: " + idComic));
    }

    private String gerarHash() throws NoSuchAlgorithmException {
        byte[] arrayByte = MessageDigest.getInstance("MD5")
                .digest((dataHoraAtual + privateApiKey + publicApiKey)
                        .getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, arrayByte).toString(16);
    }

    private ComicEntity jsonToEntity(String json) {
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

    private Integer diaDesconto(String isbn) {
        Integer ultimoNumero = Integer.parseInt(isbn.substring(isbn.length() - 1));
        if (ultimoNumero.equals(0) || ultimoNumero.equals(1)) {
            return 2;
        }
        if (ultimoNumero.equals(2) || ultimoNumero.equals(3)) {
            return 3;
        }
        if (ultimoNumero.equals(4) || ultimoNumero.equals(5)) {
            return 4;
        }
        if (ultimoNumero.equals(6) || ultimoNumero.equals(7)) {
            return 5;
        }
        if (ultimoNumero.equals(8) || ultimoNumero.equals(9)) {
            return 6;
        }
        return null;
    }

}
 