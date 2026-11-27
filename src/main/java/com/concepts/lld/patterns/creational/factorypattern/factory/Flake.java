package com.concepts.lld.patterns.creational.factorypattern.factory;

public class Flake implements Smoking {

    @Override
    public double getCost() {
        return 10.0;
    }

    @Override
    public String getName() {
        return "Flake";
    }

}
