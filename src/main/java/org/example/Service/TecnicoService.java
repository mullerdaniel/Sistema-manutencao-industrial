package org.example.Service;

import org.example.Dao.TecnicoDAO;
import org.example.Model.Tecnico;

import java.sql.SQLException;

public class TecnicoService {
    static TecnicoDAO tecnicoDAO = new TecnicoDAO();


    // CADASTRAR TECNICO
    public static void cadastrarTecnico(Tecnico tecnico) {
        try {
            tecnicoDAO.cadastrarTecnico(tecnico);
            System.out.println("\nTecnico cadastrado com sucesso!");

        }catch (SQLException e) {
            System.out.println("\nErro ao cadastrar Tecnico!");
            e.printStackTrace();
        }
    }
}
