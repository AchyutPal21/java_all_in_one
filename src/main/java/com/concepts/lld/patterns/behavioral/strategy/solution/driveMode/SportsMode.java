package com.concepts.lld.patterns.behavioral.strategy.solution.driveMode;

public class SportsMode implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is Sports Mode Drive Strategy");
    }
}
