package com.dsa.dynamicprogramming.dpquestion3;

/**
 * 
 * TotalUniquePaths
 * 
 * Question: https://leetcode.com/problems/unique-paths/description/
 * Insted of going from (0, 0) -> (m-1, n-1),
 * we will be traversing from (m-1, n-1) -> (0, 0)
 * we are doing this as for all the recursion we are doing top-bottom approach
 * so this patter will be easy for us to work.
 * 
 */
public class TotalUniquePaths {
    public int uniquePaths(int m, int n) {
        // return findPath(m-1, n-1);

        // Memo
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // return findPathMemo(m-1, n-1, dp);

        // Tabulation
        // return findPathTabu(m, n);

        // Space optimization
        return findPathSO(m, n);
    }

    // Reursion version
    // TC: O(2^n*m) SC: O(n*m)
    private int findPath(int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;

        int left = findPath(m, n-1);
        int top = findPath(m-1, n);

        return left+top;

    }

    // Memoization version
    // TC: O(m*n) SC: O(m*n)
    private int findPathMemo(int m, int n, int[][] dp) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        if (dp[m][n] != -1) return dp[m][n];

        int left = findPath(m, n-1);
        int top = findPath(m-1, n);

        dp[m][n] = left+top;

        return left+top;

    }

    // Tablulation version
    // TC: O(m*n) SC: O(m*n)
    // TLE pass for all test case
    private int findPathTabu(int m, int n) { 
        if (m < 0 || n < 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 0;
            }
        }

        // The tabulation
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = 1;
                } else {
                    int right = 0;
                    int down = 0;

                    if (col > 0) {
                        right = dp[row][col-1];
                    }

                    if (row > 0) {
                        down = dp[row-1][col];
                    }

                    dp[row][col] = right + down;
                }

            }
        }

        return dp[m-1][n-1];
    }

    // Space optimization version
    // TC: O(m*n) SC: O(n)
    private int findPathSO(int m, int n) {
        int[] dp = new int[n];

        for (int row = 0; row < m; row++) {
            int[] curr = new int[n];
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    curr[col] = 1;
                } else {
                    int right = 0;
                    int down = 0;

                    // col > 0 means we are moving in right diretion
                    if (col > 0) {
                        right = curr[col-1];
                    }
                    // row > 0 means we are moing down direction
                    if (row > 0) {
                        down = dp[col];
                    }

                    curr[col] = right + down;
                }
            }

            dp = curr;
        }

        return dp[n-1];
    }


}
