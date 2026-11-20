package com.concepts.lld.patterns.behavioral.strategy.solution;

import com.concepts.lld.patterns.behavioral.strategy.solution.driveMode.CruseMode;

public class CityVehicle extends Vehicle {
    public CityVehicle() {
        super(new CruseMode());
    }
}
