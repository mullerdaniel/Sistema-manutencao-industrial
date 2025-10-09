package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Maquina;
import org.example.Model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    // LISTAR TODAS AS PEÇAS AONDE O ESTOQUE FOR MEIOR QUE 0
    public List<Peca> listarPecasComSaldo() {
        List<Peca> pecas = new ArrayList<>();
        String sql = "SELECT id, nome, estoque FROM Peca WHERE estoque > 0";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("estoque")
                );
                pecas.add(peca);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pecas;
    }


    // LISTAR TODAS AS PEÇAS
    public List<Peca> listarPecas() {
        List<Peca> pecas = new ArrayList<>();
        String sql = "SELECT id, nome, estoque FROM Peca";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Peca peca = new Peca(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("estoque")
                );
                pecas.add(peca);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pecas;
    }
}
