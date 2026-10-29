package com.mycompany.rpg;


public class Heroi extends Personagem {

    private int energiaSuprema;
    private boolean supremoDesbloqueado;

    public Heroi(String nome, Item arma, Item armadura) {
        super(
            nome,
            1,      // Nivel inicial
            100,    // Vida maxima
            100,    // Vida atual
            10,     // Forca
            5,      // Defesa
            0,      // XP inicial
            arma,
            armadura,
            "Heroi"
        );

        this.energiaSuprema = 0;
        this.supremoDesbloqueado = false;
    }

    // Ataque normal
    @Override
    public void Atacar() {
        if (getVidaAtual() <= 0) {
            System.out.println(getNome() + " esta morto e nao pode atacar!");
            return;
        }

        int dano = getForca();

        System.out.println(getNome() + " atacou e causou "
                + dano + " de dano!");
        
        ganharEnergiaSuprema(20);
    }

    // Morte do heroi
    @Override
    public void Morrer() {
        setVidaAtual(0);
        System.out.println(getNome() + " morreu!");
    }

    // Adiciona XP e verifica se pode subir de nivel
    public void ganharXP(int quantidade) {
        if (quantidade <= 0) {
            return;
        }

        setXp(getXp() + quantidade);

        System.out.println(getNome() + " ganhou "
                + quantidade + " de XP!");

        while (getXp() >= getNivel() * 100) {
            subirNivel();
        }
    }

    // Evolucao do heroi
    public void subirNivel() {
        int xpNecessario = getNivel() * 100;

        if (getXp() < xpNecessario) {
            return;
        }

        setXp(getXp() - xpNecessario);
        setNivel(getNivel() + 1);

        setVidaMax(getVidaMax() + 20);
        setVidaAtual(getVidaMax());
        setForca(getForca() + 5);
        setDefesa(getDefesa() + 2);

        System.out.println("\n" + getNome()
                + " subiu para o nivel " + getNivel() + "!");

        System.out.println("Vida maxima: " + getVidaMax());
        System.out.println("Forca: " + getForca());
        System.out.println("Defesa: " + getDefesa());
    }

    // Acumula energia para o poder supremo
    public void ganharEnergiaSuprema(int quantidade) {
        if (quantidade <= 0 || supremoDesbloqueado) {
            return;
        }

        energiaSuprema += quantidade;

        if (energiaSuprema >= 100) {
            energiaSuprema = 100;
            supremoDesbloqueado = true;

            System.out.println("\n" + getNome()
                    + " DESBLOQUEOU O PODER SUPREMO!");
        } else {
            System.out.println("Energia suprema: "
                    + energiaSuprema + "/100");
        }
    }

    // Executa o poder supremo
    public void usarPoderSupremo() {
        if (getVidaAtual() <= 0) {
            System.out.println("Um heroi morto nao pode usar o poder supremo!");
            return;
        }

        if (!supremoDesbloqueado) {
            System.out.println("Poder supremo indisponivel! Energia: "
                    + energiaSuprema + "/100");
            return;
        }

        int danoSupremo = getForca() * 5;

        System.out.println("\n*** PODER SUPREMO! ***");
        System.out.println(getNome()
                + " liberou todo o seu poder e causou "
                + danoSupremo + " de dano!");

        energiaSuprema = 0;
        supremoDesbloqueado = false;
    }

    public int getEnergiaSuprema() {
        return energiaSuprema;
    }

    public boolean isSupremoDesbloqueado() {
        return supremoDesbloqueado;
    }
}

