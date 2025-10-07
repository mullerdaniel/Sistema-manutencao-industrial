package org.example.Service;

import org.example.Dao.OrdemManutencaoDAO;
import org.example.Model.OrdemManutencao;

import java.sql.SQLException;

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
}
