package com.mycompany.rpg;

public class RPG {

    public static void main(String[] args) {
        
        Item espada = new Item(
            "Espada de Ferro",
            "Uma espada resistente feita de ferro.",
            "Arma",
            150.00,
            1,
            5,
            30,
            10
        );

        System.out.println("Nome: " + espada.getNome());
        System.out.println("Tipo: " + espada.getTipo());
        System.out.println("Ataque: " + espada.getAtaque());
        System.out.println("Defesa: " + espada.getDefesa());
    }
}

