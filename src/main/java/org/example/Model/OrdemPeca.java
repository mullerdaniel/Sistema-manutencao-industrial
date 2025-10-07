package org.example.Model;

public class OrdemPeca {

    private int idOrdem;
    private int idPeca;
    private double quantidade;


    // CONSTRUTOR COM ID
    public OrdemPeca(int idOrdem, int idPeca, double quantidade) {
        this.idOrdem = idOrdem;
        this.idPeca = idPeca;
        this.quantidade = quantidade;
    }


    // GETs E SETs
    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}
