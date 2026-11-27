package com.concepts.lld.patterns.structural.decoratorpattern.payment;

public class CardPaymentStrategy implements PaymentStrategy {
    private final String cardLast4;

    public CardPaymentStrategy(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Card ending in " + cardLast4);
        return true;
    }
}
