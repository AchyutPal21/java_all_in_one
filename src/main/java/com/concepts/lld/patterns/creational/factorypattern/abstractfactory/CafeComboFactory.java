package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public interface CafeComboFactory {
    CoffeeDrink createCoffee();
    PastryItem createPastry();
}
