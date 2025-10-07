package org.example.View;

import org.example.Model.Maquina;
import org.example.Service.MaquinaService;

import java.util.Scanner;

public class MaquinaView {
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
}
