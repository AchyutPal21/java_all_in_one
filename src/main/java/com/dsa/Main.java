package com.dsa;

import com.dsa.dynamicprogramming.ClimbKStairs;

public class Main {

    public static void main(String[] args) {
        ClimbKStairs climb = new ClimbKStairs();
        int count = climb.calcCostJumpTabularSOpt(4, new int[]{1,2,3,4});
        System.out.println(count);
        
    }
}