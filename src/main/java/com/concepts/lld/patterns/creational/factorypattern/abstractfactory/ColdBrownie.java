package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class ColdBrownie implements PastryItem {
    
    
    @Override 
    public void serve() { System.out.println("Serving chilled fudge brownie."); }
    
    @Override 
    public double getPrice() { return 110.0; }
}
