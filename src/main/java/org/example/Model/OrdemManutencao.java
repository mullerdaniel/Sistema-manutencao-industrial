package org.example.Model;

public class OrdemManutencao {

    private int id;
    private int idMaquina;
    private int idTecnico;
    private String dataSolicitacao;
    private String status; //PENDENTE / EXECUTADA / CANCELADA


    // CONSTRUTOR COM ID
    public OrdemManutencao(int id, int idMaquina, int idTecnico, String dataSolicitacao, String status) {
        this.id = id;
        this.idMaquina = idMaquina;
        this.idTecnico = idTecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }


    // CONSTRUTOR SEM ID
    public OrdemManutencao(int idMaquina, int idTecnico, String dataSolicitacao, String status) {
        this.idMaquina = idMaquina;
        this.idTecnico = idTecnico;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }


    // GETs E SETs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
