package com.concepts.lld.patterns.creational.factorypattern.factory;

public class GoldFlake implements Smoking {

    @Override
    public String getName() {
        return "Gold Flake";
    }

    @Override
    public double getCost() {
        return 9.0;
    }

}
