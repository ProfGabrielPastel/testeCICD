
package com.mycompany.rpg;

public class Rodada {

    private int numeroRodada;
    private boolean heroiDefendendo;
    private boolean batalhaFinalizada;

    // Atributos do heroi
    private int vidaHeroi;
    private int ataqueHeroi;
    private int defesaHeroi;
    private int itensHeroi;

    // Atributos do vilao
    private int vidaVilao;
    private int ataqueVilao;
    private int defesaVilao;

    // Construtor da classe
    public Rodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;

        // Valores iniciais para teste
        vidaHeroi = 100;
        ataqueHeroi = 20;
        defesaHeroi = 5;
        itensHeroi = 3;

        vidaVilao = 80;
        ataqueVilao = 15;
        defesaVilao = 3;

        heroiDefendendo = false;
        batalhaFinalizada = false;
    }

    // Inicia a rodada
    public void iniciarRodada() {
        System.out.println("Iniciando rodada: " + numeroRodada);
        System.out.println("O heroi batalha contra o vilao.");
    }

    // Mostra os atributos dos personagens
    public void mostrarAtributos() {
        System.out.println("\n--- Atributos do Heroi ---");
        System.out.println("Vida: " + vidaHeroi);
        System.out.println("Ataque: " + ataqueHeroi);
        System.out.println("Defesa: " + defesaHeroi);
        System.out.println("Itens disponiveis: " + itensHeroi);

        System.out.println("\n--- Atributos do Vilao ---");
        System.out.println("Vida: " + vidaVilao);
        System.out.println("Ataque: " + ataqueVilao);
        System.out.println("Defesa: " + defesaVilao);
    }

    // Executa a acao escolhida pelo heroi
    public void executarAcaoHeroi() {
        java.util.Scanner entrada = new java.util.Scanner(System.in);

        System.out.println("\nEscolha uma acao:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Usar item");
        System.out.println("3 - Defender");
        System.out.println("4 - Fugir");
        System.out.print("Opcao: ");

        int opcao = entrada.nextInt();
        heroiDefendendo = false;
        if (opcao == 1) {
            int dano = ataqueHeroi - defesaVilao;
            if (dano < 1) {
                dano = 1;
            }
            vidaVilao = vidaVilao - dano;
            if (vidaVilao < 0) {
                vidaVilao = 0;
            }
            System.out.println("O heroi atacou.");
            System.out.println("Dano causado: " + dano);
        } else if (opcao == 2) {
            if (itensHeroi > 0) {
                vidaHeroi = vidaHeroi + 20;
                itensHeroi--;
                if (vidaHeroi > 100) {
                    vidaHeroi = 100;
                }
                System.out.println("O heroi usou um item.");
                System.out.println("Vida atual: " + vidaHeroi);
                System.out.println("Itens restantes: " + itensHeroi);
            } else {
                System.out.println("O heroi nao possui itens.");
            }
        } else if (opcao == 3) {
            heroiDefendendo = true;
            System.out.println("O heroi esta se defendendo.");
        } else if (opcao == 4) {
            System.out.println("O heroi fugiu da batalha.");
            batalhaFinalizada = true;
        } else {
            System.out.println("Opcao invalida.");
        }
    }
    public void executarAcaoVilao() {
        if (batalhaFinalizada == false) {
            int dano = ataqueVilao - defesaHeroi;
            if (heroiDefendendo == true) {
                dano = dano / 2;
            }
            if (dano < 1) {
                dano = 1;
            }
            vidaHeroi = vidaHeroi - dano;
            if (vidaHeroi < 0) {
                vidaHeroi = 0;
            }
            System.out.println("\nO vilao atacou.");
            System.out.println("Dano recebido pelo heroi: " + dano);
        }
    }
    public void verificarResultado() {
        if (vidaVilao <= 0) {
            System.out.println("\nO heroi venceu!");
            System.out.println("Recebeu XP e recompensas.");
            batalhaFinalizada = true;
        } else if (vidaHeroi <= 0) {
            System.out.println("\nO heroi foi derrotado.");
            batalhaFinalizada = true;
        } else {
            System.out.println("\nOs dois personagens continuam vivos.");
        }
    }
    public void finalizarRodada() {
        if (batalhaFinalizada == false) {
            numeroRodada++;
            System.out.println("\nPreparado para a proxima rodada.");
        } else {
            System.out.println("\nA batalha terminou.");
        }
    }
    public void finalizarFase() {
        if (vidaHeroi > 0 && vidaVilao <= 0) {
            System.out.println("\nFase finalizada!");
            System.out.println("O heroi recebeu as recompensas da fase.");
            System.out.println("O heroi pode usar a forja para melhorar ou criar itens.");
        } else {
            System.out.println("\nA fase nao terminou.");
        }
    }
}
