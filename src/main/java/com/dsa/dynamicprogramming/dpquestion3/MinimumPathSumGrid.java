package com.dsa.dynamicprogramming.dpquestion3;

public class MinimumPathSumGrid {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Recursive approach
        // return minPathCost(grid, m-1, n-1);

        // Memoization approach
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // return minPathCostMemo(grid, m-1, n-1, dp);

        // TABULATION
        // return minPathCostTabu(grid);

        // SPACE OPTIMIZATION
        return minPathCostSpaceOpt(grid);
    }

    // Recursive solution
    // TC: O(2^m*n) SC: O(m+n)
    private int minPathCost(int[][] grid, int m, int n) {
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0) return grid[m][n];

        int leftMinCost = minPathCost(grid, m, n-1);
        if (leftMinCost != Integer.MAX_VALUE) {
            leftMinCost += grid[m][n];
        }

        int upMinCost = minPathCost(grid, m-1, n);
        if (upMinCost != Integer.MAX_VALUE) {
            upMinCost += grid[m][n];
        }

        return Integer.min(leftMinCost, upMinCost);
    }

    // MEMOIZATION
    // TC: O(m*n) SC: O(m*n) + O(m+n)
    private int minPathCostMemo(int[][] grid, int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (m == 0 && n == 0) return grid[m][n];

        if (dp[m][n] != -1) return dp[m][n];

        int leftMinCost = minPathCost(grid, m, n-1);
        if (leftMinCost != Integer.MAX_VALUE) {
            leftMinCost += grid[m][n];
        }

        int upMinCost = minPathCost(grid, m-1, n);
        if (upMinCost != Integer.MAX_VALUE) {
            upMinCost += grid[m][n];
        }

        return dp[m][n] = Integer.min(leftMinCost, upMinCost);
    }

    // TABULATION
    // TC: O(m*n) SC: O(m*n)
    private int minPathCostTabu(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    // check for the above
                    if (i > 0) {
                        up = grid[i][j] + dp[i-1][j];
                    }

                    if (j > 0) {
                        left = grid[i][j] + dp[i][j-1];
                    }

                    dp[i][j] = Integer.min(left, up);
                }
            }
        }

        return dp[m-1][n-1];
    }

    // SPACE OPTIMIZATION
    //
    private int minPathCostSpaceOpt(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;

                    // check for the above
                    if (i > 0) {
                        up = grid[i][j] + dp[j];
                    }

                    if (j > 0) {
                        left = grid[i][j] + temp[j-1];
                    }

                    temp[j] = Integer.min(left, up);
                }
            }

            dp = temp;
        }

        return dp[n-1];
    }
}
