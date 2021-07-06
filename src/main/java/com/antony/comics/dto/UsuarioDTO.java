package com.antony.comics.dto;

import com.antony.comics.entity.ComicEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UsuarioDTO {

    private Integer id;
    @NotBlank(message = "Campo nome obrigatório")
    private String nome;
    @Email(message = "E-mail inválido")
    @NotBlank(message = "Campo e-mail obrigatório")
    private String email;
    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;
    @NotBlank(message = "Campo data de nascimento obrigatório")
    private String dataNascimento;
    private List<ComicDTO> comics;

    public UsuarioDTO(Integer id, String nome, String email, String cpf, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<ComicDTO> getComics() {
        return comics;
    }

    public void setComics(List<ComicDTO> comics) {
        this.comics = comics;
    }


}
