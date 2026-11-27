package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class WarmCroissant implements PastryItem {
    @Override 
    public void serve() { System.out.println("Serving warm butter croissant."); }
    
    @Override 
    public double getPrice() { return 90.0; }
}
