package com.mycompany.rpg;

public abstract class Personagem {
    private String nome;
    private int nivel;
    private int vidaMax;
    private int vidaAtual;
    private int forca;
    private int defesa;
    private int xp;
    private Item Arma;
    private Item armadura;
    private String classe;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Item getArma() {
        return Arma;
    }

    public void setArma(Item Arma) {
        this.Arma = Arma;
    }

    public Item getArmadura() {
        return armadura;
    }

    public void setArmadura(Item armadura) {
        this.armadura = armadura;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Personagem(String nome, int nivel, int vidaMax, int vidaAtual, int forca, int defesa, int xp, Item Arma, Item armadura, String classe) {
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.forca = forca;
        this.defesa = defesa;
        this.xp = xp;
        this.Arma = Arma;
        this.armadura = armadura;
        this.classe = classe;
    }
    
    public abstract void Atacar();
    public abstract void Morrer();
}
