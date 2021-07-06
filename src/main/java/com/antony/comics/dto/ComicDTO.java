package com.antony.comics.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class ComicDTO {

    private Integer id;
    private String titulo;
    private double preco;
    private String autores;
    private String isbn;
    private String descricao;
    private Integer diaDesconto;
    private boolean descontoAtivo;

    public ComicDTO() {
    }

    public ComicDTO(Integer id, String titulo, double preco, String autores, String isbn, String descricao, Integer diaDesconto, boolean descontoAtivo) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.autores = autores;
        this.isbn = isbn;
        this.descricao = descricao;
        this.diaDesconto = diaDesconto;
        this.descontoAtivo = descontoAtivo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDiaDesconto() {
        return diaDesconto;
    }

    public void setDiaDesconto(Integer diaDesconto) {
        this.diaDesconto = diaDesconto;
    }

    public boolean isDescontoAtivo() {
        return descontoAtivo;
    }

    public void setDescontoAtivo(boolean descontoAtivo) {
        this.descontoAtivo = descontoAtivo;
    }
}
