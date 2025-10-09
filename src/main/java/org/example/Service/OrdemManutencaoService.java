package org.example.Service;

import org.example.Dao.OrdemManutencaoDAO;
import org.example.Model.Maquina;
import org.example.Model.OrdemManutencao;

import java.sql.SQLException;
import java.util.List;

public class OrdemManutencaoService {
    private OrdemManutencaoDAO dao = new OrdemManutencaoDAO();


    // CRIAR ORDEM DE MANUTENÇÃO
    public boolean criarOrdem(OrdemManutencao ordem) {
        try {
            dao.inserir(ordem);
            return true;
        } catch (SQLException e) {
            System.out.println("\nErro ao criar ordem de manutenção.");
            e.printStackTrace();
            return false;
        }
    }


    // METODO PARA LISTAR ORDENS MANUTENÇÃO COM STATUS DEFINIDO COMO PENDENTE
    public static List<OrdemManutencao> listarOrdensManutencaoComStatusPendente() {
        return OrdemManutencaoDAO.listarOrdensManutencaoComStatusPendente();
    }


    // ATUALIZAR STATUS
    public void atualizarStatus(int id, String novoStatus) {
        try {
            OrdemManutencaoDAO.atualizarStatus(id, novoStatus);
        } catch (SQLException e) {
            System.out.println("\nErro ao atualizar status da ordem manutenção.");
            e.printStackTrace();
        }
    }
}
