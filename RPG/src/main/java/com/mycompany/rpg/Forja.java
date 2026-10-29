/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg;

/**
 *
 * @author aluno
 */
public class Forja {
    public static Item fundirItens(Item item1, Item item2) {
    // Verifica se os itens são compatíveis
    if (!item1.getTipo().equals(item2.getTipo())) {
        throw new IllegalArgumentException(
            "Só é possível fundir itens do mesmo tipo."
        );
    }

    String nome = item1.getNome() + " + " + item2.getNome();
    String descricao = "Item obtido pela fusão de "
            + item1.getNome() + " e " + item2.getNome();
    String tipo = item1.getTipo();

    double valor = (item1.getValor() + item2.getValor()) / 2;
    int quantidade = item1.getQuantidade() + item2.getQuantidade();
    int nivel = item1.getNivel() + item2.getNivel();
    int ataque = item1.getAtaque() + item2.getAtaque();
    int defesa = item1.getDefesa() + item2.getDefesa();

    return new Item(
        nome,
        descricao,
        tipo,
        valor,
        quantidade,
        nivel,
        ataque,
        defesa
    );
}
}
