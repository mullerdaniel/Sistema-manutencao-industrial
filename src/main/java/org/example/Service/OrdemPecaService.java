package org.example.Service;

import org.example.Dao.OrdemPecaDAO;
import org.example.Model.OrdemPeca;

public class OrdemPecaService {


    // INSERIR PEÇA
    private OrdemPecaDAO dao = new OrdemPecaDAO();

    public boolean inserirOrdemPeca(OrdemPeca ordemPeca) {
        return dao.inserir(ordemPeca);
    }
}
