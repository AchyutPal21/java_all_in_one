package com.dsa;

import com.dsa.dynamicprogramming.dpquestion3.MazeObstacles;
import com.dsa.dynamicprogramming.dpquestion3.UniquePathsIII;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 2, -1}
        };
        // int[][] grid = new int[][]{
        //     {0, 1},
        //     {2, 0}
        // };

        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        System.out.println(uniquePathsIII.uniquePathsIII(grid));

        
        
        

    }
}