package com.concepts.lld.patterns.structural.decoratorpattern.coffeemachine;

import java.util.Map;

import com.concepts.lld.patterns.structural.decoratorpattern.drink.Beverage;
import com.concepts.lld.patterns.structural.decoratorpattern.inventory.InventoryManager;
import com.concepts.lld.patterns.structural.decoratorpattern.payment.PaymentStrategy;

public class CoffeeMachine {
    private final InventoryManager inventory;

    public CoffeeMachine(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public void makeOrder(Beverage order, PaymentStrategy paymentStrategy) {
        Map<String, Integer> needed = order.getRequiredIngredients();

        if (!inventory.hasIngredients(needed)) {
            System.out.println("Order failed: Out of stock for " + order.getDescription());
            return;
        }

        double totalCost = order.getCost();
        boolean paid = paymentStrategy.pay(totalCost);
        if (!paid) {
            System.out.println("Order failed: Payment declined.");
            return;
        }

        inventory.consumeIngredients(needed);
        System.out.println("Dispensing: " + order.getDescription() + " | Total: ₹" + totalCost);
    }
}
