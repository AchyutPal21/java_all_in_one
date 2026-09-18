package com.dsa;

import com.dsa.dynamicprogramming.ClimbKStairs;

public class Main {

    public static void main(String[] args) {
        ClimbKStairs climb = new ClimbKStairs();
        int[] cost = new int[]{1, 2, 3, 4};
        int count = climb.solution(4, 3, cost);
        System.out.println(count);
        
    }
}