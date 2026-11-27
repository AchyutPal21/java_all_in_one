package com.concepts.lld.patterns.structural.decoratorpattern.drink;

import java.util.Map;

public interface Beverage {
    String getDescription();
    double getCost();
    Map<String, Integer> getRequiredIngredients();
}
