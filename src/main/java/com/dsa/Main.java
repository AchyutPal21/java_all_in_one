package com.dsa;

import com.dsa.dynamicprogramming.ClimbKStairs;

public class Main {

    public static void main(String[] args) {
        ClimbKStairs climb = new ClimbKStairs();
        int[] cost = new int[]{4, 2, 1, 5, 6, 3, 5, 2};
        int count = climb.solution(8, 4, cost);
        System.out.println(count);
        
    }
}