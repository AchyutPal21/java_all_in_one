package com.concepts.lld.patterns.behavioral.strategy.solution;

import com.concepts.lld.patterns.behavioral.strategy.solution.driveMode.DriveStrategy;

public class Vehicle {
    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
