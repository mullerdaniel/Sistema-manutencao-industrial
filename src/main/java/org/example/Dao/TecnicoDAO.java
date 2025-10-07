package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TecnicoDAO {


    // CADASTRAR TECNICO
    public void cadastrarTecnico(Tecnico tecnico) throws SQLException {
        String query = "INSERT INTO Tecnico (nome, especialidade) VALUES (?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, tecnico.getNome());
            stmt.setString(2, tecnico.getEspecialidade());
            stmt.execute();
        }
    }


    // LISTAR TODOS OS TECNICOS
    public List<Tecnico> listarTodos() throws SQLException {
        String query = "SELECT id, nome, especialidade FROM Tecnico";
        List<Tecnico> tecnicos = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tecnico tecnico = new Tecnico(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade")
                );
                tecnicos.add(tecnico);
            }
        }

        return tecnicos;
    }
}
