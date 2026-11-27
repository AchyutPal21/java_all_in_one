package com.concepts.lld.patterns.structural.decoratorpattern.drink;

import java.util.Map;

public class CaramelAddon extends BeverageDecorator {
    public CaramelAddon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Caramel";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 40.0;
    }

    @Override
    public Map<String, Integer> getRequiredIngredients() {
        Map<String, Integer> req = super.getRequiredIngredients();
        req.merge("CaramelSyrup", 20, Integer::sum);
        return req;
    }
}
