package com.concepts.lld.patterns.behavioral.strategy.solution;

import com.concepts.lld.patterns.behavioral.strategy.solution.driveMode.SportsMode;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsMode());
    }
}
