package org.example.Service;

import org.example.Dao.MaquinaDAO;
import org.example.Model.Maquina;

import java.sql.SQLException;
import java.util.List;

public class MaquinaService {
    static MaquinaDAO maquinaDAO = new MaquinaDAO();
    private MaquinaDAO MaquinaDAO;



    // CADASTRAR MAQUINA
    public static void cadastrarMaquina(Maquina maquina) {
        try {
            maquinaDAO.cadastrarMaquina(maquina);
            System.out.println("\nMaquina cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("\nErro ao cadastrar a Maquina!");
            e.printStackTrace();
        }
    }


    // METODO PARA LISTAR MAQUINAS COM STATUS DEFINIDO COMO OPERACIONAL
    public List<Maquina> listarMaquinasComStatusOperacionais() {
        return maquinaDAO.listarMaquinasComStatusOperacionais();
    }


    // ATUALIZAR STATUS
    public void atualizarStatus(int idMaquina, String novoStatus) {
        try {
            maquinaDAO.atualizarStatus(idMaquina, novoStatus);
        } catch (SQLException e) {
            System.out.println("\nErro ao atualizar status da máquina.");
            e.printStackTrace();
        }
    }

}
