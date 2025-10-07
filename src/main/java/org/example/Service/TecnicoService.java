package org.example.Service;

import org.example.Dao.TecnicoDAO;
import org.example.Model.Tecnico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    // LISTAR TODOS OS TECNICOS
    public static List<Tecnico> listarTodos() {
        try {
            return tecnicoDAO.listarTodos();
        } catch (SQLException e) {
            System.out.println("\nErro ao listar técnicos.");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
