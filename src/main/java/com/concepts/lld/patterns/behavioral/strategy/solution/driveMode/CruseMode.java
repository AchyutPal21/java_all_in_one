package com.concepts.lld.patterns.behavioral.strategy.solution.driveMode;

public class CruseMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is Cruse Mode Drive Strategy Mode");
    }

}
