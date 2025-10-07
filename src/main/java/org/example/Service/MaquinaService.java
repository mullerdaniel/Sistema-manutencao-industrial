package org.example.Service;

import org.example.Dao.MaquinaDAO;
import org.example.Model.Maquina;

import java.sql.SQLException;

public class MaquinaService {
    static MaquinaDAO maquinaDAO = new MaquinaDAO();

    // CADASTRAR MAQUINA
    public static void cadastrarMaquina(Maquina maquina) {
        try {
            maquinaDAO.cadastrarMaquina(maquina);
            System.out.println("\nMaquina cadastrada com sucesso!");

        }catch (SQLException e) {
            System.out.println("\nErro ao cadastrar a Maquina!");
            e.printStackTrace();
        }
    }
}
