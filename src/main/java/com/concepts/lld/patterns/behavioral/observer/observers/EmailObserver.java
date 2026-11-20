package com.concepts.lld.patterns.behavioral.observer.observers;

import com.concepts.lld.patterns.behavioral.observer.observables.Observable;

public class EmailObserver implements Observer {
    private final Observable observable;
    public String email;

    public EmailObserver(Observable observable, String email) {
        this.observable = observable;
        this.email = email;
    }

    @Override
    public void update() {
        sendEmail(email);
    }
    
    public void sendEmail(String email) {
        String message = "Notify From " + observable.getClass().getSimpleName() + " Stocks Updated. Order Now !!!";
        System.out.println("\nSending Email To: " + email);
        System.out.println(message + "\n");

    }

}
