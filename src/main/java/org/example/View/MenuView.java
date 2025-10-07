package org.example.View;

import org.example.Service.PecaService;
import org.example.Service.TecnicoService;

import java.util.Scanner;
public class MenuView {
    Scanner input = new Scanner(System.in);

    MaquinaView maquinaView = new MaquinaView();
    TecnicoView tecnicoView = new TecnicoView();
    PecaView pecaView = new PecaView();
    OrdemManutencaoView ordemManutencaoView = new OrdemManutencaoView();

    // EXIBIR MENU QUE SERA PUXADO PARA MAIN
    public void exibirMenu() {

        System.out.println("\n\n|----------------------------------------|");
        System.out.println("|--- Sistema de Manutenção Industrial ---|");
        System.out.println("|----------------------------------------|\n");
        System.out.println("1- Cadastrar Máquina");
        System.out.println("2- Cadastrar Técnico");
        System.out.println("3- Cadastrar Peça");
        System.out.println("4- Criar Ordem de Manutenção");
        System.out.println("5- Associar Peças à Ordem");
        System.out.println("6- Executar Manutenção");
        System.out.println("\n0- Sair");
        int opcao = input.nextInt();

        switch (opcao) {
            case 1: {
                maquinaView.cadastrarMaquina();
                break;
            }

            case 2: {
                tecnicoView.cadastrarTecnico();
                break;
            }

            case 3: {
                pecaView.cadastrarPeca();
                break;
            }

            case 4: {
                ordemManutencaoView.criarOrdemManutencao();
                break;
            }

            case 5: {
                break;
            }

            case 6: {
                break;
            }

            case 0: {
                System.out.println("\nSaindo...");
                break;
            }

            default: {
                System.out.println("\nOpção incorreta!");
            }
        }
    }
}
