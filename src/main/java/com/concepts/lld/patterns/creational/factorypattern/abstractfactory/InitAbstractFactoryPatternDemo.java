package com.concepts.lld.patterns.creational.factorypattern.abstractfactory;

public class InitAbstractFactoryPatternDemo {
    public void start() {
        CafeComboFactory hotFactory = new HotCafeFactory();
        new CafeOrderService(hotFactory).processCombo();

        System.out.println("---");

        CafeComboFactory icedFactory = new IcedCafeFactory();
        new CafeOrderService(icedFactory).processCombo();
    }
}
