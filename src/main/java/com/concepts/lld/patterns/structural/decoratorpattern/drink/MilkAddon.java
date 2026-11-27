package com.concepts.lld.patterns.structural.decoratorpattern.drink;

import java.util.Map;

public class MilkAddon extends BeverageDecorator {

    public MilkAddon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 55.0;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Extra Milk";
    }

    @Override
    public Map<String, Integer> getRequiredIngredients() {
        Map<String, Integer> req = super.getRequiredIngredients();
        req.merge("Milk", 60, Integer::sum);
        return req;
    }
    
    
}
