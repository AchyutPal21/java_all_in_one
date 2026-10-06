package com.dsa;

import java.time.Duration;
import java.time.LocalTime;

import com.dsa.dynamicprogramming.dpquestion3.MinimumPathSumGrid;

public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {5, 9, 6, 3, 1, 9, 4},
            {1, 5, 2, 3, 10, 15, 2},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 51, 22, 34, 110, 145, 62},
            {10, 50, 20, 30, 100, 150, 20},
            {231, 125, 152, 353, 1890, 2315, 892},
            {91, 95, 29, 39, 190, 195, 92},
            {81, 85, 82, 83, 810, 185, 82},
            {14, 54, 24, 34, 140, 415, 42},
        };


        MinimumPathSumGrid minimumPathSumGrid = new MinimumPathSumGrid();
        
        // 1. Capture the start time
        LocalTime start = LocalTime.now();
        
        System.out.println(minimumPathSumGrid.minPathSum(grid));
        
        // 2. Capture the end time explicitly
        LocalTime end = LocalTime.now();
        
        // 3. Fix the argument order: (start, end)
        Duration exetime = Duration.between(start, end);
        
        // 4. Use toMillis() or toNanos() because the algorithm runs instantly
        System.out.println("Total execution time: " + exetime.toMillis() + " ms");
        
        
        

    }
}