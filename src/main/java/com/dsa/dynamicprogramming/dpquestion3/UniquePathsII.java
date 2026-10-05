package com.dsa.dynamicprogramming.dpquestion3;


/**
 * LC 63 (Unique Paths II)
 * https://leetcode.com/problems/unique-paths-ii/
 * MazeObstacles
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Recursive
        // return totalPathRec(obstacleGrid, m-1, n-1);

        // Memoization
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // return totalPathMemo(obstacleGrid, m-1, n-1, dp);

        // Tablulation
        // return totalPathTabu(obstacleGrid);

        // Space optimization
        return totalPathSpaceOpt(obstacleGrid);
    }

    // Recursive approach
    // TC: O(2^m*n) SC: O(m+n)
    private int totalPathRec(int[][] maze, int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (maze[m][n] == 1) return 0;

        int left = totalPathRec(maze, m, n-1);
        int up = totalPathRec(maze, m-1, n);
        return left + up;
    }

    // Memoization approach
    // TC: O(m*n) SC: O(m*n) + O(m+n)
    private int totalPathMemo(int[][] maze, int m, int n, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (maze[m][n] == 1) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int left = totalPathRec(maze, m, n-1);
        int up = totalPathRec(maze, m-1, n);

        dp[m][n] = left + up;

        return left + up;
    }

    // Tabulation approach
    // TC: O(m*n) SC: O(m*n)
    private int totalPathTabu(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
    if (maze[0][0] != 0 || maze[m-1][n-1] != 0) return 0;

        int[][] dp = new int[m][n];
        // Fill dp with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Skip the maze block cell
                if (maze[i][j] == 1) continue;

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int left = 0;
                    int up = 0;

                    if (i > 0 && maze[i-1][j] != 1) {
                        up = dp[i-1][j];
                    }
                    if (j > 0 && maze[i][j-1] != 1) {
                        left = dp[i][j-1];
                    }

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    // Space optimization approach
    // TC: O(m*n) SC: O(n)
    private int totalPathSpaceOpt(int[][] maze) {
        int r_len = maze.length;
        int c_len = maze[0].length;

        // Edge case if block is in (0, 0) || (r_len - 1, c_len - 1)
        if (maze[0][0] == 1 || maze[r_len-1][c_len-1] == 1) return 0;

        int[] dp = new int[c_len];
        for (int i = 0; i < c_len; i++) {
            dp[i] = -1;
        }


        for (int row = 0; row < r_len; row++) {
            int[] curr_row = new int[c_len];
            for (int col = 0; col < c_len; col++) {
                // If we get an block then skip
                if (maze[row][col] == 1) continue;

                if (row == 0 && col == 0) {
                    // For the linear array col is the 0th index
                    curr_row[col] = 1;
                } else {
                    int left = 0;
                    int up = 0;
                    // we are in the cell who's up cell is not a block
                    if (row > 0 && maze[row - 1][col] != 1) {
                        up = dp[col]; // Above above of (x,y) is (x-1, y) here y stays the same
                    }
                    
                    // We are in the cell who's left cell is not a block
                    if (col > 0 && maze[row][col - 1] != 1) {
                        left = curr_row[col-1]; // Left cell of (x, y) is (x, y-1), here y get to previous index
                    }

                    curr_row[col] = up + left;
                }
            }

            // Assign the current row to the above dp array, in next iteration we will be able to asign a new array to curr_row
            // and this curr_row will act as a above row
            dp = curr_row;
        }

        return dp[c_len - 1];
    }

    
}
