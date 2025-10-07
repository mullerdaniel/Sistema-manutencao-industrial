package org.example.View;

import org.example.Model.Maquina;
import org.example.Service.MaquinaService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MaquinaView {
    private MaquinaService maquinaService;
    static Scanner input = new Scanner(System.in);

    // CADASTRAR MAQUINA
    public void cadastrarMaquina() {
        System.out.println("\n\n----- Cadastrar Maquina -----\n");

        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Setor: ");
        String setor = input.nextLine();
        String status = "Operacional";

        Maquina maquina = new Maquina(nome, setor, status);
        MaquinaService.cadastrarMaquina(maquina);
    }


    // EXIBIR AS MAQUINAS COM STATUS DEFINICO COMO OPERACIONAL
    private MaquinaService MaquinaService = new MaquinaService();

    public void exibirMaquinasComStatusOperacionais() {
        List<Maquina> maquinas = MaquinaService.listarMaquinasComStatusOperacionais();
        if (maquinas.isEmpty()) {
            System.out.println("\nNão há máquinas operacionais.");
        } else {
            System.out.println("\n\nMáquinas Operacionais:");
            for (Maquina maquina : maquinas) {
                System.out.println("ID: " + maquina.getId() + ", Nome: " + maquina.getNome() + ", Setor: " + maquina.getSetor());
            }
        }
    }
}
