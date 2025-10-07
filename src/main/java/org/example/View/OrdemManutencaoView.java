package org.example.View;

import org.example.Model.Maquina;
import org.example.Model.OrdemManutencao;
import org.example.Model.Tecnico;
import org.example.Service.MaquinaService;
import org.example.Service.OrdemManutencaoService;
import org.example.Service.TecnicoService;

import java.time.LocalDate;
import java.util.List;

import static org.example.View.TecnicoView.input;

public class OrdemManutencaoView {
    private MaquinaService maquinaService = new MaquinaService();
    private TecnicoService tecnicoService = new TecnicoService();
    private OrdemManutencaoService ordemService = new OrdemManutencaoService();


    public void criarOrdemManutencao() {
        System.out.println("\n\n----- Criar Ordem Manutenção -----\n");

        // 1. Listar máquinas operacionais
        List<Maquina> maquinas = maquinaService.listarMaquinasComStatusOperacionais();
        if (maquinas.isEmpty()) {
            System.out.println("\nNenhuma máquina operacional disponível.");
            return;
        }

        for (Maquina m : maquinas) {
            System.out.println("ID: " + m.getId() + " | Nome: " + m.getNome() + " | Setor: " + m.getSetor());
        }

        System.out.print("\nDigite o ID da máquina: ");
        int idMaquina = input.nextInt();
        input.nextLine();

        boolean maquinaValida = maquinas.stream().anyMatch(m -> m.getId() == idMaquina);
        if (!maquinaValida) {
            System.out.println("\nID de máquina inválido.");
            return;
        }

        List<Tecnico> tecnicos = tecnicoService.listarTodos();
        if (tecnicos.isEmpty()) {
            System.out.println("\nNenhum técnico disponível.");
            return;
        }

        for (Tecnico t : tecnicos) {
            System.out.println("ID: " + t.getId() + " | Nome: " + t.getNome() + " | Especialidade: " + t.getEspecialidade());
        }

        System.out.print("\nDigite o ID do técnico: ");
        int idTecnico = input.nextInt();
        input.nextLine();

        boolean tecnicoValido = tecnicos.stream().anyMatch(t -> t.getId() == idTecnico);
        if (!tecnicoValido) {
            System.out.println("\nID de técnico inválido.");
            return;
        }

        String dataAtual = LocalDate.now().toString();

        String status = "PENDENTE";

        OrdemManutencao ordem = new OrdemManutencao(idMaquina, idTecnico, dataAtual, status);
        boolean sucesso = ordemService.criarOrdem(ordem);

        if (sucesso) {
            maquinaService.atualizarStatus(idMaquina, "EM_MANUTENCAO");

            System.out.println("\nOrdem de manutenção criada com sucesso!");
        } else {
            System.out.println("\nFalha ao criar a ordem de manutenção.");
        }
    }
    }

