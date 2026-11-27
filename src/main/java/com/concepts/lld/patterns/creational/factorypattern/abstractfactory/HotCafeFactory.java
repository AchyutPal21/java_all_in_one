package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class HotCafeFactory implements CafeComboFactory {
    
    
    @Override 
    public CoffeeDrink createCoffee() { return new HotEspresso(); }
    
    @Override 
    public PastryItem createPastry() { return new WarmCroissant(); }
}
