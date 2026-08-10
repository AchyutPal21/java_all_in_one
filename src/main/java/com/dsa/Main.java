package com.dsa;

import com.dsa.dynamicprogramming.Q2;

public class Main {

    public static void main(String[] args) {
        Q2 q = new Q2();
        int n = 3;
        System.out.println("Distinct for " + n + " : " + q.countStepOpt(n));
        
    }
}