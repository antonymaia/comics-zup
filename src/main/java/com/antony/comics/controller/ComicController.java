package com.antony.comics.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;

import com.antony.comics.business.ComicsService;
import com.antony.comics.client.MarvelClient;
import com.antony.comics.dto.ComicDTO;
import com.antony.comics.mapper.ComicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping(path = "/comics")
public class ComicController {


    @Autowired
    private MarvelClient marvelClient;
    @Autowired
    private ComicsService service;


    @PostMapping(value = "/{id}")
    ResponseEntity<ComicDTO> cadastrar(@PathVariable("id") Integer id) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        ComicDTO dto = ComicMapper.toDto(service.cadastrar(id));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PostMapping(value = "/usuariocomic")
    ResponseEntity cadastrarComicDoUsuario(@RequestParam("idUsuario") Integer idUsuario,
                                                   @RequestParam("idComic") Integer idComic){
        service.cadastrarComicDoUsuario(idUsuario, idComic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
