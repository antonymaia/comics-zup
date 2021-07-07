package com.antony.comics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMICS")
public class ComicEntity {

    @Id
    private Integer id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private double preco;
    @Column(length = 1000)
    private String autores;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false, length = 1000)
    private String descricao;
    private Integer diaDesconto;
    private boolean descontoAtivo;

    public ComicEntity(){}

    public ComicEntity(Integer id, String titulo, double preco, String autores, String isbn, String descricao, Integer diaDesconto, boolean descontoAtivo) {
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
