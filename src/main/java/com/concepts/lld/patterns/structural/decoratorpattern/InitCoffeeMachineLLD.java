package com.concepts.lld.patterns.structural.decoratorpattern;

import com.concepts.lld.patterns.structural.decoratorpattern.coffeemachine.CoffeeMachine;
import com.concepts.lld.patterns.structural.decoratorpattern.drink.Beverage;
import com.concepts.lld.patterns.structural.decoratorpattern.drink.CaramelAddon;
import com.concepts.lld.patterns.structural.decoratorpattern.drink.Espresso;
import com.concepts.lld.patterns.structural.decoratorpattern.drink.Latte;
import com.concepts.lld.patterns.structural.decoratorpattern.drink.MilkAddon;
import com.concepts.lld.patterns.structural.decoratorpattern.inventory.InventoryManager;
import com.concepts.lld.patterns.structural.decoratorpattern.payment.CardPaymentStrategy;
import com.concepts.lld.patterns.structural.decoratorpattern.payment.UpiPaymentStrategy;

public class InitCoffeeMachineLLD {
    public void start() {
        InventoryManager inventory = new InventoryManager();
        inventory.addIngredient("CoffeeBeans", 100);
        inventory.addIngredient("Water", 500);
        inventory.addIngredient("Milk", 400);
        inventory.addIngredient("CaramelSyrup", 100);
        inventory.printStock();

        CoffeeMachine machine = new CoffeeMachine(inventory);

        Beverage customLatte = new CaramelAddon(new MilkAddon(new Latte()));
        machine.makeOrder(customLatte, new UpiPaymentStrategy("user@upi"));

        Beverage quickEspresso = new Espresso();
        machine.makeOrder(quickEspresso, new CardPaymentStrategy("4242"));

        inventory.printStock();
    }
}
