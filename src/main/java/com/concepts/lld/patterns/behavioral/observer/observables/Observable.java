package com.concepts.lld.patterns.behavioral.observer.observables;

import com.concepts.lld.patterns.behavioral.observer.observers.Observer;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void ping();
    int getStock();
    void setStock(int stocks);

}
