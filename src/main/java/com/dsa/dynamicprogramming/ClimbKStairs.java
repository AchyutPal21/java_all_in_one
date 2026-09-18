package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ClimbKStairs {
    public int solution(int n, int k, int[] energy) {
        return minEnergy(n, k, energy);
    }

    private int minEnergy(int n, int k, int[] energy) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (n == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (0 > n-i) break;

            int cost = minEnergy(n-1, k, energy);
            
            if (Integer.MAX_VALUE != cost) {
                cost += energy[n-1] + ((n-i)*(n-i));
                min = Integer.min(min, cost);
            }
            
        }

        return  min;
    }
    
}
