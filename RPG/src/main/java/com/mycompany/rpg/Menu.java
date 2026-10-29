/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

/**
 *
 * @author matheus
 */
import java.util.Scanner;

public class Menu {

    public enum Turno { Jogador, Inimigo }

    private final Scanner scanner = new Scanner(System.in);
    private Turno turno = Turno.Jogador;

    // Executa o menu até o jogador fazer uma ação que encerra o turno
    public void turnoDoJogador() {
        turno = Turno.Jogador;

        while (turno == Turno.Jogador) {
            exibir();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    atacar();
                    turno = Turno.Inimigo; // atacar passa a rodada
                    break;
                case 2:
                    abrirInventario();     // não gasta o turno
                    break;
                case 3:
                    abrirForja();          // não gasta o turno
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void exibir() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Atacar");
        System.out.println("2 - Inventário");
        System.out.println("3 - Forja");
        System.out.print("Escolha: ");
    }

    private int lerOpcao() {
        String linha = scanner.nextLine().trim();
        try {
            return Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            return -1; // cai no default do switch
        }
    }

    private void atacar() {
        System.out.println("Você atacou o inimigo!");
        // TODO: calcular dano
    }

    private void abrirInventario() {
        System.out.println("Abrindo inventário...");
        // TODO: lógica do inventário
    }

    private void abrirForja() {
        System.out.println("Abrindo forja...");
        // TODO: lógica da forja
    }

    public Turno getTurno() {
        return turno;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.turnoDoJogador();
        System.out.println("Agora é o turno: " + menu.getTurno());
    }
}
