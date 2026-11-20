package com.concepts.lld.patterns.behavioral.observer.observables;

import java.util.LinkedList;
import java.util.List;

import com.concepts.lld.patterns.behavioral.observer.observers.Observer;

public class S26Ultra implements Observable {
    private List<Observer> observerList;
    private int stocks;

    public S26Ultra() {
        observerList = new LinkedList<>();
        stocks = 0;

    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void ping() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    @Override
    public int getStock() {
        return stocks;
    }

    @Override
    public void setStock(int stocks) {
        if (this.stocks == 0) {
            ping();
        }

        this.stocks = stocks;
    }
}
