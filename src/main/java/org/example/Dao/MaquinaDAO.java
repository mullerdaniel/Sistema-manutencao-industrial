package org.example.Dao;

import org.example.Conexao;
import org.example.Model.Maquina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


    // METODO PARA LISTAR MAQUINAS COM STATUS DEFINIDO COMO OPERACIONAL
    public List<Maquina> listarMaquinasComStatusOperacionais() {
        List<Maquina> maquinas = new ArrayList<>();
        String sql = "SELECT id, nome, setor, status FROM Maquina WHERE status = 'OPERACIONAL'";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Maquina maquina = new Maquina(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("setor"),
                        rs.getString("status")
                );
                maquinas.add(maquina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maquinas;
    }


    // ATUALIZAR O STATUS
    public void atualizarStatus(int idMaquina, String novoStatus) throws SQLException {
        String sql = "UPDATE Maquina SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, idMaquina);

            stmt.executeUpdate();
        }
    }

}

