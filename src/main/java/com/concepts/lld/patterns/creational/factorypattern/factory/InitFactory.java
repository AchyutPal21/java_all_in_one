package com.concepts.lld.patterns.creational.factorypattern.factory;

public class InitFactory {
    public void start() {
        Smoking cigarette = SmokingFactory.startSmoking("flake");
        System.out.println("Started Smoking " + cigarette.getName() + " at a cost of " + cigarette.getCost());
    }
}
