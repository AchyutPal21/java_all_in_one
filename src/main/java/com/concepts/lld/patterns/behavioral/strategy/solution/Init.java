package com.concepts.lld.patterns.behavioral.strategy.solution;

/**
 * Solution for Strategy Pattern
 * 
 * We have created an Interface DriveStrategy that has a method drive 
 * other classes AdventureMode, CruseMode and SportsMode implements 
 * the interface and define their drive logic addordingly as per the mode.
 * 
 * Now as we have the Vehicle, here also we have the vehicle but this time 
 * Vehicle class don't have the drive() method itself instead Vehicle class 
 * has-a DriveStrategy object (by using constructor injection) the child class 
 * AdventureVehicle, CityVehicle and SportsVehicle send the drive mode to the 
 * parent using super() construction and in parent call the drive() method upon 
 * the drive mode object send by the child class.
 * 
 * When you find that the child class are having redundent code logic and the is 
 * not present in the parent class, at that situation you should think of this pattern.
 * 
 * Init
 */

public class Init {
    public void start() {
        Vehicle vehicle1 = new AdventureVehicle();
        vehicle1.drive();

        Vehicle vehicle2 = new CityVehicle();
        vehicle2.drive();

        Vehicle vehicle3 = new SportsVehicle();
        vehicle3.drive();
    }
}
