package com.dsa.dynamicprogramming;

// Ninja Training
// This question is about solving the quesiton in adjacent manner but with 2D array
// This is a tricky question that I have solve so far.
// 5 ⭐️⭐️⭐️⭐️⭐️ question.
public class NinjaTraining {
    public int solve(int[][] arr) {
        int n = arr.length;
        
        // return maxMeritPoints(n-1, arr, 3);
        
        int[][] dp = new int[n][arr[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return maxMeritPointsMemo(n-1, arr, arr[0].length, dp);
    }

    private int maxMeritPoints(int n, int[][] arr, int prev) {
        if (n == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr[n].length; i++) {
                if (i != prev) {
                    max = Integer.max(max, arr[n][i]);
                }
            }

            return max;
        }

        int curr_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[n].length; i++) {
            if (i != prev) {
                int merit = maxMeritPoints(n-1, arr, i) + arr[n][i];
                curr_max = Integer.max(curr_max, merit);
            }
        }

        return curr_max;
    }

    private int maxMeritPointsMemo(int n, int[][] arr, int prev, int[][] dp) {
        if (n == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr[n].length; i++) {
                if (i != prev) {
                    max = Integer.max(max, arr[n][i]);
                }
            }

            return max;
        }

        if (prev < dp[0].length && dp[n][prev] != -1) {
            return dp[n][prev];
        }

        int curr_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[n].length; i++) {
            if (i != prev) {
                int merit = maxMeritPoints(n-1, arr, i) + arr[n][i];
                curr_max = Integer.max(curr_max, merit);
            }
        }

        System.out.println("n:" + n + " prev:" + prev + " curr_max: " + curr_max);
        if (prev < arr[n].length) {
            dp[n][prev] = curr_max;
        }

        return curr_max;
    }

}
