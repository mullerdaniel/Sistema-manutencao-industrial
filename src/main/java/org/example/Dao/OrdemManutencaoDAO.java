package org.example.Dao;


import org.example.Conexao;
import org.example.Model.Maquina;
import org.example.Model.OrdemManutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdemManutencaoDAO {


    // INSERIR ORDEM DE MANUTENÇÃO
    public void inserir(OrdemManutencao ordem) throws SQLException {
        String sql = "INSERT INTO OrdemManutencao (idMaquina, idTecnico, dataSolicitacao, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordem.getIdMaquina());
            stmt.setInt(2, ordem.getIdTecnico());
            stmt.setString(3, ordem.getDataSolicitacao());
            stmt.setString(4, ordem.getStatus());

            stmt.execute();
        }
    }


    // LISTAR TODAS AS ORDENS COM STATUS DEFINIDO COMO PENDENTE
    public static List<OrdemManutencao> listarOrdensManutencaoComStatusPendente() {
        List<OrdemManutencao> ordemManutencaos = new ArrayList<>();
        String sql = "SELECT id, idMaquina, idTecnico, dataSolicitacao, status FROM OrdemManutencao WHERE status = 'PENDENTE'";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OrdemManutencao ordemManutencao = new OrdemManutencao(
                        rs.getInt("id"),
                        rs.getInt("idMaquina"),
                        rs.getInt("idTecnico"),
                        rs.getString("dataSolicitacao"),
                        rs.getString("status")
                );
                ordemManutencaos.add(ordemManutencao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordemManutencaos;
    }


    // ATUALIZAR O STATUS
    public static void atualizarStatus(int id, String novoStatus) throws SQLException {
        String sql = "UPDATE OrdemManutencao SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }
}
