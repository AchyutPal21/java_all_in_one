package com.concepts.lld.patterns.behavioral.strategy.solution;

import com.concepts.lld.patterns.behavioral.strategy.solution.driveMode.SportsMode;

public class AdventureVehicle extends Vehicle {
    public AdventureVehicle() {
        // Sending the Sports Mode Strategy
        super(new SportsMode());
    }
}
