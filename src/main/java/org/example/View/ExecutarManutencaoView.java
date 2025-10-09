package org.example.View;

import org.example.Model.OrdemManutencao;
import org.example.Model.Peca;
import org.example.Service.MaquinaService;
import org.example.Service.OrdemManutencaoService;
import org.example.Service.PecaService;

import java.util.List;
import java.util.Scanner;


// EXECUTAR MANUTENÇÃO
public class ExecutarManutencaoView {
    private Scanner input = new Scanner(System.in);

    private OrdemManutencaoService ordemService = new OrdemManutencaoService();
    private PecaService pecaService = new PecaService();
    OrdemManutencaoView ordemManutencaoView = new OrdemManutencaoView();
    MaquinaService maquinaService = new MaquinaService();


    public void executarManutencao() {
        System.out.println("\n\n----- Executar Manutenção -----\n");

        List<OrdemManutencao> ordensPendentes = ordemService.listarOrdensManutencaoComStatusPendente();


        if (ordensPendentes.isEmpty()) {
            System.out.println("\nNão existem ordens pendentes.");
            return;
        }

        System.out.println("\nOrdens pendentes: ");

        for (int i = 0; i < ordensPendentes.size(); i++) {
            OrdemManutencao ordem = ordensPendentes.get(i);
            System.out.println((i + 1) + " - Ordem ID: " + ordem.getId() + ", Status: " + ordem.getStatus());
        }

        int opcaoOrdem = -1;

        while (opcaoOrdem < 1 || opcaoOrdem > ordensPendentes.size()) {
            System.out.print("\nEscolha a ordem (número): ");

            if (input.hasNextInt()) {
                opcaoOrdem = input.nextInt();
                input.nextLine();

                if (opcaoOrdem < 1 || opcaoOrdem > ordensPendentes.size()) {
                    System.out.println("\nOpção inválida, tente novamente.");
                }

            } else {
                System.out.println("\nEntrada inválida, digite um número.");
                input.nextLine();
            }
        }

        OrdemManutencao ordemSelecionada = ordensPendentes.get(opcaoOrdem - 1);
        int idOrdem = ordemSelecionada.getId();
        int idMaquina = ordemSelecionada.getIdMaquina();

        List<Peca> pecas = pecaService.listarPecasComSaldo();

        if (pecas.isEmpty()) {
            System.out.println("\nNão existem peças disponíveis em estoque.");
            return;
        }

        System.out.println("Peças disponíveis:");

        for (int i = 0; i < pecas.size(); i++) {
            Peca peca = pecas.get(i);
            System.out.println((i + 1) + " - " + peca.getNome() + " - Quantidade: " + peca.getEstoque());
        }

        int opcaoPeca = -1;

        while (opcaoPeca < 1 || opcaoPeca > pecas.size()) {
            System.out.print("\nEscolha a peça (número): ");

            if (input.hasNextInt()) {
                opcaoPeca = input.nextInt();
                input.nextLine();

                if (opcaoPeca < 1 || opcaoPeca > pecas.size()) {
                    System.out.println("\nOpção inválida, tente novamente.");
                }

            } else {
                System.out.println("\nEntrada inválida, digite um número.");
                input.nextLine();
            }
        }

        Peca pecaSelecionada = pecas.get(opcaoPeca - 1);

        double quantidade = 0;

        boolean quantidadeValida = false;
        while (!quantidadeValida) {
            System.out.print("\nInforme a quantidade necessária (máximo " + pecaSelecionada.getEstoque() + "): ");

            if (input.hasNextDouble()) {
                quantidade = input.nextDouble();
                input.nextLine();

                if (quantidade <= 0) {
                    System.out.println("\nQuantidade negativa ou zero não é permitida.");

                } else if (quantidade > pecaSelecionada.getEstoque()) {
                    System.out.println("\nQuantidade maior que o quantidade disponível (" + pecaSelecionada.getEstoque() + ").");

                } else {
                    quantidadeValida = true;

                    System.out.println("\nEstoque atualizado: "+ (pecaSelecionada.getEstoque() - quantidade));
                    maquinaService.atualizarStatus(idMaquina, "OPERACIONAL");
                    ordemService.atualizarStatus(idOrdem ,"EXECUTADA");

                    System.out.println("\nManutenção concluida com sucesso!");

                    return;
                }

            } else {
                System.out.println("\nEntrada inválida, digite um número válido.");
                input.nextLine();
            }
        }

    }
}