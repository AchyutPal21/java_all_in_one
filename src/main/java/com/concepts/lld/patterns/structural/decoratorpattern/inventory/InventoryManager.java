package com.concepts.lld.patterns.structural.decoratorpattern.inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addIngredient(String ingredient, int quantity) {
        stock.merge(ingredient, quantity, Integer::sum);
    }

    public boolean hasIngredients(Map<String, Integer> required) {
        for (Map.Entry<String, Integer> entry : required.entrySet()) {
            int available = stock.getOrDefault(entry.getKey(), 0);
            if (available < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void consumeIngredients(Map<String, Integer> required) {
        if (!hasIngredients(required)) {
            throw new IllegalStateException("Insufficient ingredients to fulfill order.");
        }
        for (Map.Entry<String, Integer> entry : required.entrySet()) {
            stock.put(entry.getKey(), stock.get(entry.getKey()) - entry.getValue());
        }
    }

    public void printStock() {
        System.out.println("Current Inventory: " + stock);
    }
}
