package com.concepts;

import com.concepts.lld.patterns.behavioral.observer.InitObserver;
import com.concepts.lld.patterns.behavioral.strategy.solution.Init;

public class Main {

    public static void main(String[] args) {
        InitObserver init = new InitObserver();
        init.start();

    }
}