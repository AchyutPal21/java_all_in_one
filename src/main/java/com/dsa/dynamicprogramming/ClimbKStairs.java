package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class ClimbKStairs {
    public int calcCostJump(int n, int[] costs) {
        // _ 1 2 3 4 5 6 7 8 9
        // 0 2 3 1 3 1 1 5 8 2
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (n == 1) {
            return costs[n-1] + 1;
        }

        int min_cost = Integer.MAX_VALUE;
        int oneStepJump = calcCostJump(n-1, costs) + costs[n-1] + (1*1);
        min_cost = Integer.min(min_cost, oneStepJump);

        if (n >= 2) {
            int twoStepJump = calcCostJump(n-2, costs);
            if (twoStepJump != Integer.MAX_VALUE) {
                twoStepJump += costs[n-1] + (2*2);
                min_cost = Integer.min(min_cost, twoStepJump);
            }
        }

        if (n >= 3) {
            int threeStepJump = calcCostJump(n-3, costs);
            if (threeStepJump != Integer.MAX_VALUE) {
                threeStepJump += costs[n-1] + (3*3);
                min_cost = Integer.min(min_cost, threeStepJump);
            }
        }

        return min_cost;
    }

        public int calcCostJumpDP(int n, int[] costs, List<Integer> dp) {
        // _ 1 2 3 4 5 6 7 8 9
        // 0 2 3 1 3 1 1 5 8 2
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (n == 1) {
            return costs[n-1] + 1;
        }

        if (dp.get(n) != -1) {
            return dp.get(n);
        }

        int min_cost = Integer.MAX_VALUE;
        int oneStepJump = calcCostJump(n-1, costs) + costs[n-1] + (1*1);
        min_cost = Integer.min(min_cost, oneStepJump);

        if (n >= 2) {
            int twoStepJump = calcCostJump(n-2, costs);
            if (twoStepJump != Integer.MAX_VALUE) {
                twoStepJump += costs[n-1] + (2*2);
                min_cost = Integer.min(min_cost, twoStepJump);
            }
        }

        if (n >= 3) {
            int threeStepJump = calcCostJump(n-3, costs);
            if (threeStepJump != Integer.MAX_VALUE) {
                threeStepJump += costs[n-1] + (3*3);
                min_cost = Integer.min(min_cost, threeStepJump);
            }
        }

        dp.set(n, min_cost);
        return min_cost;
    }


    public int calcCostJumpTabularSOpt(int n, int[] costs) {
        // costs[] is 1-based index

        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) {
            return costs[0] + 1;
        }
        // dp.add((costs[0] + 1)); // This is for the step 1 cost
        // 0  1  2  3  4  5
        // 0 

        int one_jump = costs[0] + 1;
        int two_jump = 0;
        int three_jump = 0;

        int curr_stair_cost = Integer.MAX_VALUE;

        for (int i = 2; i <= n; i++) {
            one_jump = one_jump + costs[i-1] + (1*1);
            curr_stair_cost = Integer.min(curr_stair_cost, one_jump);

            if (i >= 2) {
                two_jump = two_jump + costs[i-1] + (2*2);
                curr_stair_cost = Integer.min(curr_stair_cost, two_jump);
            }


            if (i >= 3) {
                three_jump = three_jump + costs[i-1] + (3*3);
                curr_stair_cost = Integer.min(curr_stair_cost, three_jump);
            }

            three_jump = two_jump;
            two_jump = one_jump;
            one_jump = curr_stair_cost;
        }

        return  one_jump;
    }

}
