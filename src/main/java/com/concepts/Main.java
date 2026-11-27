package com.concepts;

import com.concepts.lld.patterns.behavioral.observer.InitObserver;
import com.concepts.lld.patterns.behavioral.strategy.solution.Init;
import com.concepts.lld.patterns.creational.factorypattern.factory.InitFactory;
import com.concepts.lld.patterns.structural.decoratorpattern.InitCoffeeMachineLLD;

public class Main {

    public static void main(String[] args) {
        // InitCoffeeMachineLLD init = new InitCoffeeMachineLLD();
        // init.start();

        InitFactory initFactory = new InitFactory();
        initFactory.start();

    }
}