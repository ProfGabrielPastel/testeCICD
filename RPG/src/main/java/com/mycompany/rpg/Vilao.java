/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;
/**
 *
 * @author aluno
 */

public class Vilao extends Personagem {

    private String habilidadePassiva;
    private boolean passivaAtivada;

    private int energiaMaligna;
    private boolean habilidadeAtivaDisponivel;

    public Vilao(String nome, Item arma, Item armadura) {
        super(
            nome,
            1,      // Nivel inicial
            120,    // Vida maxima
            120,    // Vida atual
            12,     // Forca
            4,      // Defesa
            0,      // XP
            arma,
            armadura,
            "Vilao"
        );

        this.habilidadePassiva = "Regeneracao Sombria";
        this.passivaAtivada = false;
        this.energiaMaligna = 0;
        this.habilidadeAtivaDisponivel = false;
    }

    // Ataque normal
    @Override
    public void Atacar() {

        if (getVidaAtual() <= 0) {
            System.out.println(getNome()
                    + " esta morto e nao pode atacar!");
            return;
        }

        int dano = getForca();

        System.out.println(getNome()
                + " atacou e causou "
                + dano + " de dano!");

        ganharEnergiaMaligna(25);
    }

    // Morte do vilao
    @Override
    public void Morrer() {
        setVidaAtual(0);

        System.out.println(getNome()
                + " foi derrotado!");
    }

    // Habilidade passiva
    public void usarPassiva() {

        if (passivaAtivada) {
            System.out.println("A passiva ja esta ativa!");
            return;
        }

        int cura = 20;

        setVidaAtual(
            Math.min(getVidaAtual() + cura, getVidaMax())
        );

        passivaAtivada = true;

        System.out.println(getNome()
                + " ativou "
                + habilidadePassiva
                + " e recuperou "
                + cura + " de vida!");
    }

    // Acumula energia para habilidade ativa
    public void ganharEnergiaMaligna(int quantidade) {

        if (quantidade <= 0 || habilidadeAtivaDisponivel) {
            return;
        }

        energiaMaligna += quantidade;

        if (energiaMaligna >= 100) {
            energiaMaligna = 100;
            habilidadeAtivaDisponivel = true;

            System.out.println("\n"
                    + getNome()
                    + " desbloqueou sua HABILIDADE ATIVA!");
        } else {

            System.out.println("Energia Maligna: "
                    + energiaMaligna
                    + "/100");
        }
    }

    // Habilidade ativa
    public void usarHabilidadeAtiva() {

        if (getVidaAtual() <= 0) {
            System.out.println("Um vilao morto nao pode usar habilidades!");
            return;
        }

        if (!habilidadeAtivaDisponivel) {
            System.out.println("Habilidade ativa indisponivel! Energia: "
                    + energiaMaligna
                    + "/100");
            return;
        }

        int dano = getForca() * 4;

        System.out.println("\n*** EXPLOSAO DAS TREVAS ***");
        System.out.println(getNome()
                + " liberou sua energia sombria e causou "
                + dano + " de dano!");

        energiaMaligna = 0;
        habilidadeAtivaDisponivel = false;
    }

    public int getEnergiaMaligna() {
        return energiaMaligna;
    }

    public boolean isHabilidadeAtivaDisponivel() {
        return habilidadeAtivaDisponivel;
    }

    public String getHabilidadePassiva() {
        return habilidadePassiva;
    }

}