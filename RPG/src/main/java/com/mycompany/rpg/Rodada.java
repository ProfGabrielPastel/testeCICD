
package com.mycompany.rpg;

import java.util.Scanner;

public class Rodada {

    private int numeroRodada;

    // Atributos do heroi
    private int vidaHeroi;
    private int ataqueHeroi;
    private int defesaHeroi;
    private int itensHeroi;

    // Atributos do vilao
    private int vidaVilao;
    private int ataqueVilao;
    private int defesaVilao;

    private boolean heroiDefendendo;
    private boolean batalhaFinalizada;

    private Scanner entrada = new Scanner(System.in);

    
    public Rodada(int numeroRodada) {
        this.numeroRodada = numeroRodada;

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

    
    public void iniciarRodada() {
        while (batalhaFinalizada == false) {
            System.out.println("\nRodada " + numeroRodada);

            mostrarAtributos();
            executarAcaoHeroi();

            if (batalhaFinalizada == false) {
                if (vidaVilao <= 0) {
                    verificarResultado();
                } else {
                    executarAcaoVilao();
                    verificarResultado();
                }
            }

            if (batalhaFinalizada == false) {
                finalizarRodada();
            }
        }

        finalizarFase();
    }


    public void mostrarAtributos() {
        System.out.println("\nHeroi - Vida: " + vidaHeroi);
        System.out.println("Ataque: " + ataqueHeroi);
        System.out.println("Defesa: " + defesaHeroi);
        System.out.println("Itens: " + itensHeroi);

        System.out.println("\nVilao - Vida: " + vidaVilao);
        System.out.println("Ataque: " + ataqueVilao);
        System.out.println("Defesa: " + defesaVilao);
    }

  
    public void executarAcaoHeroi() {
        System.out.println("\n1 - Atacar");
        System.out.println("2 - Usar item");
        System.out.println("3 - Defender");
        System.out.println("4 - Fugir");

        int opcao = entrada.nextInt();
        heroiDefendendo = false;

        if (opcao == 1) {
            int dano = ataqueHeroi - defesaVilao;

            if (dano < 1) {
                dano = 1;
            }

            vidaVilao = vidaVilao - dano;
            System.out.println("Dano causado: " + dano);

        } else if (opcao == 2) {
            if (itensHeroi > 0) {
                vidaHeroi = vidaHeroi + 20;
                itensHeroi--;

                if (vidaHeroi > 100) {
                    vidaHeroi = 100;
                }

                System.out.println("Vida do heroi: " + vidaHeroi);
            } else {
                System.out.println("Nao ha itens disponiveis.");
            }

        } else if (opcao == 3) {
            heroiDefendendo = true;
            System.out.println("O heroi esta defendendo.");

        } else if (opcao == 4) {
            batalhaFinalizada = true;
            System.out.println("O heroi fugiu.");

        } else {
            System.out.println("Opcao invalida.");
        }
    }

   
    public void executarAcaoVilao() {
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

        System.out.println("Dano recebido: " + dano);
    }

  
    public void verificarResultado() {
        if (vidaVilao <= 0) {
            System.out.println("O heroi venceu!");
            System.out.println("Recebeu XP e recompensas.");
            batalhaFinalizada = true;

        } else if (vidaHeroi <= 0) {
            System.out.println("O heroi foi derrotado.");
            batalhaFinalizada = true;
        }
    }

    public void finalizarRodada() {
        numeroRodada++;
    }

  
    public void finalizarFase() {
        if (vidaHeroi > 0 && vidaVilao <= 0) {
            System.out.println("Fase concluida!");
            System.out.println("O heroi pode usar a forja.");
        }
    }
}
