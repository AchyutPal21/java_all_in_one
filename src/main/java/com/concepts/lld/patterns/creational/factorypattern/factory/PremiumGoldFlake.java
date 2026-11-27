package com.concepts.lld.patterns.creational.factorypattern.factory;

public class PremiumGoldFlake implements Smoking {

    @Override
    public double getCost() {
        return 25.0;
    }

    @Override
    public String getName() {
        return "Premium Gold Flake";
    }
}
