package com.antony.comics.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String dataNascimento;
    @ManyToMany()
    @JoinTable(joinColumns = {@JoinColumn(name = "usuario_id")},
               inverseJoinColumns = {@JoinColumn(name = "comic_id")})
    private List<ComicEntity> comics;

    public UsuarioEntity(){}

    public UsuarioEntity(Integer id, String nome, String email, String cpf, String dataNascimento) {
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

    public List<ComicEntity> getComics() {
        return comics;
    }

    public void setComics(List<ComicEntity> comics) {
        this.comics = comics;
    }
}
