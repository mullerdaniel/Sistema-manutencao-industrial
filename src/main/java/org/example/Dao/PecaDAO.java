package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Maquina;
import org.example.Model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PecaDAO {


    // CADASTRAR PEÇA
    public static void cadastrarPeca(Peca peca) throws SQLException {
        String query = "INSERT INTO Peca (nome, estoque) VALUES (?, ?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, peca.getNome());
            stmt.setDouble(2, peca.getEstoque());
            stmt.execute();
        }
    }
}
