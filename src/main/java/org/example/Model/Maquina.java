package org.example.Model;

public class Maquina {

    private int id;
    private String nome;
    private String setor;
    private String status; // OPERACIONAL / EM_MANUTENCAO


    // CONSTRUTOR COM ID
    public Maquina(int id, String nome, String setor, String status) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.status = status;
    }


    // CONSTRUTOR SEM ID
    public Maquina(String nome, String setor, String status) {
        this.nome = nome;
        this.setor = setor;
        this.status = status;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
