package com.concepts.lld.patterns.behavioral.strategy.problem;

/**
 * Behavioral Pattern: Strategy
 * 
 * Here the problem lies in the redundent of code logic
 * Vehicle class is a parent class and its child class
 * AdventureVehicle, CityVehicle and SportsVehicle extends Vehicle class
 * Now the AdventureVehicle and SportsVhicle has the same drive logic
 * which brings the redundency of the code. This can leads to mass repetation
 * when class grows and features increase.
 * 
 * Init
 */
public class Init {
    public void start() {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();
    }
}
