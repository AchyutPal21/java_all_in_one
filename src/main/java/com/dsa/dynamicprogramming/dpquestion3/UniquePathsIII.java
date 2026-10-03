package com.dsa.dynamicprogramming.dpquestion3;

/**
- LC: 980 -> https://leetcode.com/problems/unique-paths-iii/description/
- UniquePathsIII
 */
public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int start_i = 0;
        int start_j = 0;
        // Start at 1 to account for the starting cell itself, 
        // since we decrement on the very first recursive call.
        int empty_squares = 1; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                }
                if (grid[i][j] == 0) {
                    empty_squares++;
                }
            }
        }

        return findPathsRec(grid, start_i, start_j, empty_squares);
    }

    private int findPathsRec(
            int[][] grid,
            int curr_i,
            int curr_j,
            int empty_squares) {
        
        // Out of bounds checks
        if (curr_i < 0 || curr_i >= grid.length || curr_j < 0 || curr_j >= grid[0].length) {
            return 0;
        }

        // Don't move on blocked cells OR already visited cells
        if (grid[curr_i][curr_j] == -1) {
            return 0;
        }

        // Reached the target
        if (grid[curr_i][curr_j] == 2) {
            if (empty_squares != 0) {
                return 0;
            }
            return 1;
        }

        // 1. MARK the current cell as visited before moving forward
        int temp = grid[curr_i][curr_j];
        grid[curr_i][curr_j] = -1;

        // 2. RECURSE in all 4 directions
        int up = findPathsRec(grid, curr_i - 1, curr_j, empty_squares - 1);
        int right = findPathsRec(grid, curr_i, curr_j + 1, empty_squares - 1);
        int down = findPathsRec(grid, curr_i + 1, curr_j, empty_squares - 1);
        int left = findPathsRec(grid, curr_i, curr_j - 1, empty_squares - 1);

        // 3. BACKTRACK by unmarking the cell so other paths can use it
        grid[curr_i][curr_j] = temp;

        return up + right + down + left;
    }
}