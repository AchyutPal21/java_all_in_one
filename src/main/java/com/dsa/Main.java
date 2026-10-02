package com.dsa;

import com.dsa.dynamicprogramming.dpquestion3.MazeObstacles;

public class Main {

    public static void main(String[] args) {
        int[][] maze = new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        
        
        MazeObstacles mazeObstacles = new MazeObstacles();
        System.out.println(mazeObstacles.uniquePathsWithObstacles(maze));

    }
}