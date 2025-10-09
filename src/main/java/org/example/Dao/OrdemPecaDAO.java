package org.example.Dao;

import org.example.Conexao;
import org.example.Model.OrdemPeca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemPecaDAO {


    // INSERIR ORDEM PEÇA
    public boolean inserir(OrdemPeca ordemPeca) {
        String sql = "INSERT INTO OrdemPeca (idOrdem, idPeca, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordemPeca.getIdOrdem());
            stmt.setInt(2, ordemPeca.getIdPeca());
            stmt.setDouble(3, ordemPeca.getQuantidade());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
