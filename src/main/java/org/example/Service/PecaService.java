package org.example.Service;

import org.example.Dao.PecaDAO;
import org.example.Model.Peca;
import org.example.Model.Tecnico;

import java.sql.SQLException;

public class PecaService {
    static PecaDAO pecaDAO = new PecaDAO();


    // CADASTRAR PEÇA
    public static void cadastrarPeca(Peca peca) {
        try {
            PecaDAO.cadastrarPeca(peca);
            System.out.println("\nPeça cadastrado com sucesso!");

        }catch (SQLException e) {
            System.out.println("\nErro ao cadastrar Peça!");
            e.printStackTrace();
        }
    }
}
