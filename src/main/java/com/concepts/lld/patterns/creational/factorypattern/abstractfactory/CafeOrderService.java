package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class CafeOrderService {
    private final CoffeeDrink coffee;
    private final PastryItem pastry;

    public CafeOrderService(CafeComboFactory factory) {
        this.coffee = factory.createCoffee();
        this.pastry = factory.createPastry();
    }

    public void processCombo() {
        coffee.prepare();
        pastry.serve();
        double total = coffee.getPrice() + pastry.getPrice();
        System.out.println("Combo Total: ₹" + total);
    }
}
