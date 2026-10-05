package com.dsa.dynamicprogramming.dpquestion3;

/**
 * This Maze Obstacles is a variation question from unique paths.
 * 
 * Question: You are given an m*n maze where you can move in 
 * (i+1, j) and (i, j+1) directions only, 0 represent empty cells
 * -1 as block/dead cells. You have to move from top-left corner 
 * to bottom-right corner, and return total posibble ways to 
 * reach from start(0, 0) to (m-1, n-1)
 * 
 * @return int
 */

public class MazeObstaclesII {
    public int mazeObstacles(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        
        // Recursion version
        // here we are moving from (m-1, n-1) -> (0, 0)
        // so we can move in left and up direction
        // return findPathRec(maze, m-1, n-1);

        // Memoization
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // return findPathMemo(maze, m-1, n-1, dp);

        // TABULATION APPROACH
        // return findPathTabu(maze);

        // SPACE OPTIMIZATION APPROACH
        return findPathSpacOpt(maze);
    }

    private int findPathRec(int[][] maze, int i, int j) {
        // To check index are within the maze
        if (i < 0 || j < 0) return 0;

        // To check the maze cell is blocked
        if (maze[i][j] == -1) return 0;

        // When reached the destination
        if (i == 0 && j == 0) return 1;

        int up = findPathRec(maze, i-1, j);
        int left = findPathRec(maze, i, j-1);

        return up + left;
    }

    private int findPathMemo(int[][] maze, int i, int j, int[][] dp) {
        // To check index are within the maze
        if (i < 0 || j < 0) return 0;

        // To check the maze cell is blocked
        if (maze[i][j] == -1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        // When reached the destination
        if (i == 0 && j == 0) return 1;

        int up = findPathMemo(maze, i-1, j, dp);
        int left = findPathMemo(maze, i, j-1, dp);

        return dp[i][j] = up + left;
    }

    private int findPathTabu(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == -1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                } else {
                    int up = 0;
                    int left = 0;

                    if (j > 0) {
                        left = dp[i][j-1];
                    }

                    if (i > 0) {
                        up = dp[i-1][j];
                    }

                    dp[i][j] = left + up;
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int findPathSpacOpt(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == -1) {
                    temp[j] = 0;
                } else if (i == 0 && j == 0) {
                    temp[0] = 1;
                } else {
                    int up = 0;
                    int left = 0;

                    if (j > 0) {
                        left = temp[j-1];
                    }

                    if (i > 0) {
                        up = dp[j];
                    }

                    temp[j] = left + up;
                }
            }

            dp = temp;
        }

        return dp[n-1];
    }


}
