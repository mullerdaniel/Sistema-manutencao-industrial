package org.example.Dao;


import org.example.Conexao;
import org.example.Model.OrdemManutencao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdemManutencaoDAO {


    // INSERIR ORDEM DE MANUTENÇÃO
    public void inserir(OrdemManutencao ordem) throws SQLException {
        String sql = "INSERT INTO OrdemManutencao (idMaquina, idTecnico, dataSolicitacao, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ordem.getIdMaquina());
            stmt.setInt(2, ordem.getIdTecnico());
            stmt.setString(3, ordem.getDataSolicitacao()); // YYYY-MM-DD
            stmt.setString(4, ordem.getStatus());

            stmt.execute();
        }
    }
}
