package org.example.Service;

import org.example.Dao.PecaDAO;
import org.example.Model.Peca;

import java.sql.SQLException;
import java.util.List;

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


    // LISTAR TODAS AS PEÇAS COM ESTOQUE MAIOR QUE 0
    private PecaDAO dao = new PecaDAO();

    public List<Peca> listarPecasComSaldo() {
        return dao.listarPecasComSaldo();
    }


    // LISTAR TODAS AS PEÇAS
    private PecaDAO pecasDAO = new PecaDAO();

    public List<Peca> listarPecas() {
        return pecasDAO.listarPecas();
    }
}
