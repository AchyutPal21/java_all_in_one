package com.dsa;

import com.dsa.dynamicprogramming.ClimbingStairsII;

public class Main {

    public static void main(String[] args) {
        ClimbingStairsII q = new ClimbingStairsII();
        int n = 4;
        int[] costs = new int[]{1,2,3,4};
        System.out.println("Min cost: " + q.climbStairs(n, costs));
        
    }
}