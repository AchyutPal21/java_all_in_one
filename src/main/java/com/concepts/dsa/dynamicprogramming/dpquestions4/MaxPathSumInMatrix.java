package com.concepts.dsa.dynamicprogramming.dpquestions4;

import java.util.Arrays;

public class MaxPathSumInMatrix {
    public int solve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Recursive
        // int max = Integer.MIN_VALUE;
        // for (int i = n - 1; i >= 0; i--) {
        //     max = Integer.max(max, maxPathSum(matrix, m - 1, i));
        // }

        // return max;

        // Memoization
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // int max = Integer.MIN_VALUE;
        // for (int i = n - 1; i >= 0; i--) {
        //     max = Integer.max(max, maxPathSumMemo(matrix, m - 1, i, dp));
        // }

        // return max;


        // Tabulation approach
        // return maxPathSumTabu(matrix);

        // Space optimization
        return maxPathSumSpaceOpt(matrix);

    }

    // RECURSION APPROACH
    // TC: O(3^m) SC: O(m)
    private int maxPathSum(int[][] mtx, int m, int n) {
        if (m == 0 && n >= 0 && n < mtx[m].length) {
            return mtx[m][n];
        }

        if (n < 0 || n >= mtx[m].length) {
            return 0;
        }


        int leftDiagonal = mtx[m][n] + maxPathSum(mtx, m - 1, n - 1);
        int up = mtx[m][n] + maxPathSum(mtx, m - 1, n);
        int rightDiagonal = mtx[m][n] + maxPathSum(mtx, m - 1, n + 1);
        

        return Integer.max(leftDiagonal, Integer.max(up, rightDiagonal));
    }

    // MEMOIZATION APPROACH
    // TC: O(m*n) SC: O(m*n) + O(m)
    private int maxPathSumMemo(int[][] mtx, int m, int n, int[][] dp) {
        if (m == 0 && n >= 0 && n < mtx[m].length) {
            return mtx[m][n];
        }

        if (n < 0 || n >= mtx[m].length) {
            return 0;
        }

        if (dp[m][n] != -1) return dp[m][n];


        int leftDiagonal = mtx[m][n] + maxPathSumMemo(mtx, m - 1, n - 1, dp);
        int up = mtx[m][n] + maxPathSumMemo(mtx, m - 1, n, dp);
        int rightDiagonal = mtx[m][n] + maxPathSumMemo(mtx, m - 1, n + 1, dp);
        

        return dp[m][n] = Integer.max(leftDiagonal, Integer.max(up, rightDiagonal));
    }

    // TABULATION APPROACH:
    // TC: O(m*n) + O(n) + O(n) SC: O(m*n)
    private int maxPathSumTabu(int[][] mtx) {
        int m = mtx.length;
        int n = mtx[0].length;

        // Base case for 0th position is solved
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = mtx[0][i];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int leftDiagonal = mtx[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                }

                int up = mtx[i][j] + dp[i - 1][j];

                int rightDiagonal = mtx[i][j];
                if (j + 1 < n) {
                    rightDiagonal += dp[i - 1][j + 1];
                }

                dp[i][j] = Integer.max(leftDiagonal, Integer.max(up, rightDiagonal));
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, dp[m - 1][i]);
        }

        return max;
    }

    // SPACE OPTIMIZATION
    // TC: O(m*n) SC: O(n)
    private int maxPathSumSpaceOpt(int[][] mtx) {
        int m = mtx.length;
        int n = mtx[0].length;

        // Base case for 0th position is solved
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = mtx[0][i];
        }


        for (int i = 1; i < m; i++) {
            
            int[] curr = new int[n];

            for (int j = 0; j < n; j++) {
                int leftDiagonal = mtx[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[j - 1];
                }

                int up = mtx[i][j] + dp[j];

                int rightDiagonal = mtx[i][j];
                if (j + 1 < n) {
                    rightDiagonal += dp[j + 1];
                }

                curr[j] = Integer.max(leftDiagonal, Integer.max(up, rightDiagonal));
            }

            dp = curr;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, dp[i]);
        }

        return max;
    }
}
