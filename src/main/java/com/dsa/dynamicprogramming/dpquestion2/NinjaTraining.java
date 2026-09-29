package com.dsa.dynamicprogramming.dpquestion2;

// Ninja Training
// This question is about solving the quesiton in adjacent manner but with 2D array
// This is a tricky question that I have solve so far.
// 5 ⭐️⭐️⭐️⭐️⭐️ question.
public class NinjaTraining {
    public int solve(int[][] arr) {
        int n = arr.length;
        
        // => Recursion version
        // return maxMeritPoints(n-1, arr, 3);
        
        // Tabulation (memoization) version
        // int[][] dp = new int[n][arr[0].length+1];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= arr[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }

        // return maxMeritPointsMemo(n-1, arr, arr[0].length, dp);

        // Space optimization verison
        return maxMeritPointsSpaceOptimization(arr);

    }

    private int maxMeritPoints(int n, int[][] arr, int prev) {
        if (n == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr[n].length; i++) {
                if (i != prev) {
                    max = Integer.max(max, arr[n][i]);
                }
            }

            return max;
        }

        int curr_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[n].length; i++) {
            if (i != prev) {
                int merit = maxMeritPoints(n-1, arr, i) + arr[n][i];
                curr_max = Integer.max(curr_max, merit);
            }
        }

        return curr_max;
    }

    private int maxMeritPointsMemo(int n, int[][] arr, int prev, int[][] dp) {
        if (n == 0) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr[n].length; i++) {
                if (i != prev) {
                    max = Integer.max(max, arr[n][i]);
                }
            }

            return max;
        }

        if (dp[n][prev] != -1) {
            return dp[n][prev];
        }

        int curr_max = Integer.MIN_VALUE;
        for (int i = 0; i < arr[n].length; i++) {
            if (i != prev) {
                int merit = maxMeritPointsMemo(n-1, arr, i, dp) + arr[n][i];
                curr_max = Integer.max(curr_max, merit);
            }
        }

        return dp[n][prev] = curr_max;
    }


    private int maxMeritPointsSpaceOptimization(int[][] points) {
        int n = points.length;
        int tasks = points[0].length;

        // dp[] size is tasks+1 coz in the size-1 index our ans will get stored the max of all the task
        int[] dp = new int[tasks+1];

        // We have caluated the day wise task max value
        dp[0] = Integer.max(points[0][1], points[0][2]);
        dp[1] = Integer.max(points[0][0], points[0][2]);
        dp[2] = Integer.max(points[0][0], points[0][1]);
        // This index stores the max of all the day
        dp[3] = Integer.max(points[0][0], Integer.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] meritPts = new int[tasks+1];

            for (int lastDayTask = 0; lastDayTask <= tasks; lastDayTask++) {
                for (int currDayTask = 0; currDayTask < tasks; currDayTask++) {
                    if (currDayTask != lastDayTask) {
                        meritPts[lastDayTask] = Integer.max(
                            meritPts[lastDayTask], 
                            points[day][currDayTask] + dp[currDayTask]
                        );
                    }
                }
            }

            dp = meritPts;
        }

        return dp[tasks];

    }

}
