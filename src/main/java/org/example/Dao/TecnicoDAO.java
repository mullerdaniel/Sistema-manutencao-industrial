package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Tecnico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
