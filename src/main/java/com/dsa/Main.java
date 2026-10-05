package com.dsa;

import com.dsa.dynamicprogramming.dpquestion3.MazeObstaclesII;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {0, -1, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        MazeObstaclesII mazeObstaclesII = new MazeObstaclesII();
        System.out.println(mazeObstaclesII.mazeObstacles(grid));

        
        
        

    }
}