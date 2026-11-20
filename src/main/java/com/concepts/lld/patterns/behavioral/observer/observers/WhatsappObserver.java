package com.concepts.lld.patterns.behavioral.observer.observers;

import com.concepts.lld.patterns.behavioral.observer.observables.Observable;

public class WhatsappObserver implements Observer {

    private final Observable observable;
    public String whatsappNo;

    public WhatsappObserver(Observable observable, String whatsappNo) {
        this.observable = observable;
        this.whatsappNo = whatsappNo;
    }

    @Override
    public void update() {
        sendMessage(whatsappNo);
    }
    
    public void sendMessage(String whatsappNo) {
        String message = "Notify From " + observable.getClass().getSimpleName() + " Stocks Updated. Order Now !!!";
        System.out.println("\nSending Message to: " + whatsappNo);
        System.out.println(message + "\n");

    }

}
