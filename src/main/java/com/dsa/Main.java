package com.dsa;

import java.util.ArrayList;
import java.util.List;

import com.dsa.dynamicprogramming.ClimbKStairs;
import com.dsa.dynamicprogramming.NinjaTraining;

public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {10, 50, 1},
            {5, 100, 11}
        };
        NinjaTraining nt = new NinjaTraining();
        nt.solve(arr);
    }
}