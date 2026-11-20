package com.concepts.lld.patterns.behavioral.strategy.solution.driveMode;

public class AdventureMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is Adventure Mode Drive Strategy");
    }
}
