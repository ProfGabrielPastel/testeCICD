package com.mycompany.rpg;

/**
 *
 * @author aluno
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private final double maxWeight;
    private final Map<Item, Integer> items;

    public Inventario(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new HashMap<>();
    }

    public boolean addItem(Item item, int quantity) {
        if (quantity <= 0) return false;

        double currentWeight = getTotalWeight();
        double addedWeight = item.getWeight() * quantity;

        if (currentWeight + addedWeight > maxWeight) {
            System.out.println("❌ Inventário cheio! Não é possível carregar mais peso.");
            return false;
        }

        items.put(item, items.getOrDefault(item, 0) + quantity);
        System.out.println("✅ Adicionado: " + quantity + "x " + item.getName());
        return true;
    }

    public boolean removeItem(Item item, int quantity) {
        if (!items.containsKey(item) || quantity <= 0) {
            System.out.println("❌ Item não encontrado no inventário.");
            return false;
        }

        int currentQty = items.get(item);
        if (quantity > currentQty) {
            System.out.println("❌ Quantidade insuficiente no inventário.");
            return false;
        }

        if (quantity == currentQty) {
            items.remove(item);
        } else {
            items.put(item, currentQty - quantity);
        }

        System.out.println("🗑️ Removido: " + quantity + "x " + item.getName());
        return true;
    }

    public double getTotalWeight() {
        double total = 0.0;
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            total += entry.getKey().getWeight() * entry.getValue();
        }
        return total;
    }

    public void showInventory() {
        System.out.println("\n===== INVENTÁRIO (Peso: " + getTotalWeight() + "/" + maxWeight + " kg) =====");
        if (items.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                System.out.println("- " + entry.getKey().getName() + " x" + entry.getValue() + 
                                   " (Peso unitário: " + entry.getKey().getWeight() + " kg)");
            }
        }
        System.out.println("====================================================\n");
    }

    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }
}