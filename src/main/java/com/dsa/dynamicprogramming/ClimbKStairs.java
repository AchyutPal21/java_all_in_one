package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ClimbKStairs {
    public int solution(int n, int k, int[] energy) {
        // return minEnergy(n, k, energy);
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return minEnergyTabulation(n, k, energy, dp);

    }

    // TC: O(k^n) SC: O(n)
    private int minEnergy(int n, int k, int[] energy) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (n == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n-i >= 0) {
                int cost = minEnergy(n-i, k, energy);
                if (Integer.MAX_VALUE != cost) {
                    // energy[j] + (j-i)^2 => energy[j] + (n-(n-i))^2 => energy[j] + (i)^2
                    cost += energy[n-1] + (i*i); 
                    min = Integer.min(min, cost);
                }
            }
        }

        return  min;
    }
    
    // TC: O(k*n) SC: O(n)
    private int minEnergyDP(int n, int k, int[] energy, int[] dp) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n-i >= 0) {
                int cost = minEnergy(n-i, k, energy);
                if (Integer.MAX_VALUE != cost) {
                    // energy[j] + (j-i)^2 => energy[j] + (n-(n-i))^2 => energy[j] + (i)^2
                    cost += energy[n-1] + (i*i); 
                    min = Integer.min(min, cost);
                }
            }
        }

        return  min;
    }

    
    private int minEnergyTabulation(int n, int k, int[] energy, int[] dp) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }

        if (n == 0) return 0;
        dp[0] = 0;

        // Outer loop is for running all the steps/levels
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // Innter loop is for each K steps
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0) {
                    int cost = dp[i-j] + energy[i-1] + (j*j); // i is i, but j is i+j, So, (j-i)^2 => i+j - j => i
                    min = Integer.min(min, cost);
                }
            }

            dp[i] = min;
            System.out.println("Min: " + min);
        }

        return  dp[n];
    }


}
