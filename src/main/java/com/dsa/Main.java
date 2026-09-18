package com.dsa;

import com.dsa.dynamicprogramming.ClimbKStairs;

public class Main {

    public static void main(String[] args) {
        ClimbKStairs climb = new ClimbKStairs();
        int[] cost = new int[]{5, 1, 6, 2};
        int count = climb.solution(cost.length, 3, cost);
        System.out.println("Output: " + count);
        
    }
}