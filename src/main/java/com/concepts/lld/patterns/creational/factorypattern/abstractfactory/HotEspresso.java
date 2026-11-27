package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class HotEspresso implements CoffeeDrink {
    @Override
    public void prepare() { System.out.println("Brewing hot espresso at 93°C..."); }
    
    @Override
    public double getPrice() { return 120.0; }
}
