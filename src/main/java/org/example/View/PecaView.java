package org.example.View;

import org.example.Dao.PecaDAO;
import org.example.Model.Peca;
import org.example.Model.Tecnico;
import org.example.Service.PecaService;
import org.example.Service.TecnicoService;

import java.util.Scanner;

public class PecaView {
    static Scanner input = new Scanner(System.in);


    // CADASTRAR PEÇA
    public static void cadastrarPeca() {
        System.out.println("\n\n----- Cadastrar Peça -----\n");

        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Estoque: ");
        Double estoque = input.nextDouble();

        Peca peca = new Peca(nome, estoque);
        PecaService.cadastrarPeca(peca);
    }
}
