package com.antony.comics.controller;

import com.antony.comics.business.ComicsService;
import com.antony.comics.entity.ComicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/comics")
public class ComicController {

    @Autowired
    private ComicsService service;

    @PostMapping(value = "/{id}")
    ResponseEntity<ComicEntity> cadastrar(@PathVariable("id") Integer id) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        service.cadastrar(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/usuariocomic")
    ResponseEntity<ComicEntity> cadastrarComicDoUsuario(@RequestParam("idUsuario") Integer idUsuario,
                                                   @RequestParam("idComic") Integer idComic){
        service.cadastrarComicDoUsuario(idUsuario, idComic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
