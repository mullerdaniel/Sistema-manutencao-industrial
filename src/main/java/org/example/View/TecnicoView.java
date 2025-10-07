package org.example.View;

import org.example.Model.Tecnico;
import org.example.Service.TecnicoService;

import java.util.List;
import java.util.Scanner;

public class TecnicoView {
    static Scanner input = new Scanner(System.in);


    // CADASTRAR TECNICO
    public void cadastrarTecnico() {
        System.out.println("\n\n----- Cadastrar Técnico -----\n");

        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Especialidade: ");
        String especialidade = input.nextLine();

        Tecnico tecnico = new Tecnico(nome, especialidade);
        TecnicoService.cadastrarTecnico(tecnico);
    }


    // LISTAR TODOS OS TECNICOS
    public void listarTecnicos() {
        System.out.println("\n\n----- Lista de Técnicos -----\n");
        List<Tecnico> tecnicos = TecnicoService.listarTodos();

        if (tecnicos.isEmpty()) {
            System.out.println("\nNenhum técnico cadastrado.");
            return;
        }

        for (Tecnico tecnico : tecnicos) {
            System.out.println("ID: " + tecnico.getId() +
                    " | Nome: " + tecnico.getNome() +
                    " | Especialidade: " + tecnico.getEspecialidade());
        }
    }
}
