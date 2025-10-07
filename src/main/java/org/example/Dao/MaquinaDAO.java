package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Maquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinaDAO {

    // CADASTRAR MAQUINA
    public void cadastrarMaquina(Maquina maquina) throws SQLException {
        String query = "INSERT INTO Maquina (nome, setor, status) VALUES (?, ?, ?)";

        try(Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, maquina.getNome());
            stmt.setString(2, maquina.getSetor());
            stmt.setString(3, maquina.getStatus());
            stmt.execute();
        }
    }
}
