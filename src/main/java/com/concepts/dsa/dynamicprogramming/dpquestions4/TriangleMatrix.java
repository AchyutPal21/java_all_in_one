package com.concepts.dsa.dynamicprogramming.dpquestions4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * TriangleMatrix
 * 
 * Question: You are given an triangle matrix
 * 1
 * 2 3
 * 3 6 7
 * 8 9 6 10
 * 
 * Your task is to find the min cost per row to reach
 * from ith row to n-1th row.
 * You can move in down (i+1, j) or diagonal (i+1, j+1) directions only.
 * 
 */

public class TriangleMatrix {

    public int solve(int[][] matrix) {
    // public int solve(List<List<Integer>> matrix) { // Particularly for the List<List<Integer>>
        // return minCostRow(matrix, 0, 0);

        // Memoization
        int m = matrix.length;
        int n = matrix[m-1].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return minCostRowMemo(matrix, 0, 0, dp);

        // Tabulation
        // return minCostRowTabu(matrix);

        // Memoization
        // return minCostRowSpaceOpt(matrix);
        // return minCostRowSpaceOptList(matrix);
    }

    // RECURSIVE APPROACH
    private int minCostRow(int[][] matrix, int i, int j) {
        
        // Base case
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }

        int down = matrix[i][j] + minCostRow(matrix, i+1, j);
        int diagonal = matrix[i][j] + minCostRow(matrix, i+1, j+1);

        return Integer.min(down, diagonal);
    }

    // MEMOIZATION APPROACH
    private int minCostRowMemo(int[][] matrix, int i, int j, int[][] dp) {
        // Base case
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) return dp[i][j];

        int down = matrix[i][j] + minCostRowMemo(matrix, i+1, j, dp);
        int diagonal = matrix[i][j] + minCostRowMemo(matrix, i+1, j+1, dp);

        return dp[i][j] = Integer.min(down, diagonal);
    }

    private int minCostRowTabu(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[m-1].length;

        int[][] dp = new int[m][n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (i == m - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int down = matrix[i][j] + dp[i + 1][j];
                    int diagonal = matrix[i][j] + dp[i + 1][j + 1];

                    dp[i][j] = Integer.min(down, diagonal);
                }
            }
        } 

        return dp[0][0];
    }

    // SPACE OPTIMIZATION APPROACH
    private int minCostRowSpaceOpt(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[m-1].length;

        int[] dp = new int[n];
        
        for (int i = m - 1; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = i; j >= 0; j--) {
                if (i == m - 1) {
                    temp[j] = matrix[i][j];
                } else {
                    int down = matrix[i][j] + dp[j];
                    int diagonal = matrix[i][j] + dp[j + 1];

                    temp[j] = Integer.min(down, diagonal);
                }
            }

            dp = temp;
        } 

        return dp[0];
    }

    private int minCostRowSpaceOptList(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(m - 1).size();

        List<Integer> dp = new ArrayList<Integer>();

        for (int i = m - 1; i >= 0; i--) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == m - 1) {
                    temp.add(j, matrix.get(i).get(j));
                } else {
                    int down = matrix.get(i).get(j) + dp.get(j);
                    int diagonal = matrix.get(i).get(j) + dp.get(j + 1);

                    temp.add(j, Integer.min(down, diagonal));
                }
            }

            dp = temp;
        }

        return dp.get(0);
    }

}
