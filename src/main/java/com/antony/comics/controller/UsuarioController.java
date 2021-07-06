package com.antony.comics.controller;

import com.antony.comics.business.UsuarioService;
import com.antony.comics.dto.UsuarioDTO;
import com.antony.comics.entity.UsuarioEntity;
import com.antony.comics.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<UsuarioDTO> cadastrar(@Valid @RequestBody UsuarioDTO dto){
       UsuarioEntity usuarioEntity = service.cadastrar(UsuarioMapper.toEntity(dto));
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}").buildAndExpand(usuarioEntity.getId()).toUri();
       return  ResponseEntity.created(uri).build();
   }
   @GetMapping( value = "/{id}")
    ResponseEntity<UsuarioDTO> buscar(@PathVariable("id") Integer id){
        UsuarioDTO  usuarioDTO = UsuarioMapper.toDto(service.buscar(id));
        return  ResponseEntity.ok().body(usuarioDTO);
   }
}
