package com.concepts.lld.patterns.structural.decoratorpattern.drink;

import java.util.HashMap;
import java.util.Map;

public class Espresso implements Beverage {

    @Override
    public double getCost() {
        return 150.0;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public Map<String, Integer> getRequiredIngredients() {
        Map<String, Integer> ing = new HashMap<>();
        ing.put("CoffeeBeans", 18);
        ing.put("Water", 40);
        return ing;
    }
    
}
