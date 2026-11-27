package com.concepts.lld.patterns.structural.decoratorpattern.drink;

import java.util.HashMap;
import java.util.Map;

/**
 * This abstract class Is-a and Has-a relation with the Beverage
 * 
 * BeverageDecorator
 */
public abstract class BeverageDecorator implements Beverage {
    protected final Beverage beverage;

    protected BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Map<String, Integer> getRequiredIngredients() {
        return new HashMap<>(beverage.getRequiredIngredients());
    }

    
}
