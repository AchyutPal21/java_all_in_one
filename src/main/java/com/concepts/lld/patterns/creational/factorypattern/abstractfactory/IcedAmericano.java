package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class IcedAmericano implements CoffeeDrink {
    @Override 
    public void prepare() { System.out.println("Pouring espresso over ice & cold water..."); }
    
    @Override 
    public double getPrice() { return 140.0; }
}
