package com.banco.backend.models;

/*
* Modelo do Cliente
* Por: Felipe Vieira
* */

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente_table")
public class ClienteModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clienteID")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "cpf", length = 11)
    private  String cpf;

    @Column(name = "senha", length = 20)
    private  String senha;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    public Genero genero;

    @OneToMany(mappedBy = "clienteID",cascade = CascadeType.ALL)
    private List<ContaModel> contas = new ArrayList<ContaModel>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
