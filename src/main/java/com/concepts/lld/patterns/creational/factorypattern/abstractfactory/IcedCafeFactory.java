package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class IcedCafeFactory implements CafeComboFactory {
    
    @Override 
    public CoffeeDrink createCoffee() { return new IcedAmericano(); }
    
    @Override 
    public PastryItem createPastry() { return new ColdBrownie(); }
}
