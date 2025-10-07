package org.example.Model;

public class Peca {

    private int id;
    private String nome;
    private Double estoque;


    // CONSTRUTOR COM ID
    public Peca(int id, String nome, Double estoque) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
    }


    // CONSTRUTOR SEM ID
    public Peca(String nome, Double estoque) {
        this.nome = nome;
        this.estoque = estoque;
    }


    // GETs E SETs
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

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }
}
