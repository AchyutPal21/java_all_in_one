package com.concepts.lld.patterns.behavioral.observer;

import com.concepts.lld.patterns.behavioral.observer.observables.MacBookAir;
import com.concepts.lld.patterns.behavioral.observer.observables.Observable;
import com.concepts.lld.patterns.behavioral.observer.observables.S26Ultra;
import com.concepts.lld.patterns.behavioral.observer.observers.EmailObserver;
import com.concepts.lld.patterns.behavioral.observer.observers.Observer;
import com.concepts.lld.patterns.behavioral.observer.observers.WhatsappObserver;

public class InitObserver {
    public void start() {
        // Observable
        Observable macbookair = new MacBookAir();
        Observable s26ultra = new S26Ultra();

        // Observers
        Observer email1 = new EmailObserver(macbookair, "user1@bluezoid.in");
        Observer email2 = new EmailObserver(macbookair, "user2@bluezoid.in");
        Observer email3 = new EmailObserver(macbookair, "user3@bluezoid.in");

        Observer whatsapp1 = new WhatsappObserver(s26ultra, "9876000001");
        Observer whatsapp2 = new WhatsappObserver(s26ultra, "9876000002");
        Observer whatsapp3 = new WhatsappObserver(s26ultra, "9876000003");

        // Observer subscribe to the Observable
        macbookair.add(email1);
        macbookair.add(email2);
        macbookair.add(email3);
        macbookair.add(whatsapp1);
        
        s26ultra.add(whatsapp3);
        s26ultra.add(email3);
        s26ultra.add(email2);
        s26ultra.add(whatsapp1);
        s26ultra.add(whatsapp2);
        s26ultra.add(whatsapp3);


        // Observals update stocks to notify observer
        macbookair.setStock(10);
        s26ultra.setStock(4);
        
        
    }
}
