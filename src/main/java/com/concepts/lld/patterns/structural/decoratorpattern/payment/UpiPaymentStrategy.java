package com.concepts.lld.patterns.structural.decoratorpattern.payment;

public class UpiPaymentStrategy implements PaymentStrategy {
    private final String upiId;

    public UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI (" + upiId + ")");
        return true;
    }
}
