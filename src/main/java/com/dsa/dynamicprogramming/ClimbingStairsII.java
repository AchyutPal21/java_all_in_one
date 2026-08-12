package com.dsa.dynamicprogramming;
// Question: Leetcode (Medium)

// 3693. Climbing Stairs II
// https://leetcode.com/problems/climbing-stairs-ii/description/

public class ClimbingStairsII {
  public int climbStairs(int n, int[] costs) {
    // Recursion call
    // return minCost(n, costs);

    // DP memoization call
    // int[] dp = new int[n+1];
    // Arrays.fill(dp, -1);
    // return minCostMemo(n, costs, dp);

    // Tabulation call
    // return minCostTabu(n, costs);

    // Tabulation space optimization
    return minCostSpaceOpt(n, costs);

  }

  // Recursion version
  // TC: O(3^n) SC: O(n)
  private int minCost(int n, int[] costs) {

    // For invalid step we return max cost
    if (n < 0) {
      return Integer.MAX_VALUE;
    }

    // For step at 0 we give cost to 0
    if (n == 0) {
      return 0;
    }

    // 1-step jump: (n - 1) -> n
    int oneStep = minCost(n - 1, costs);
    if (oneStep != Integer.MAX_VALUE) {
      oneStep += (costs[n - 1] + (1 * 1));
    }

    // 2-step jump: (n - 2) -> n
    // if (n - 2 >= 0) { } we don't need this because, we are handling for out of
    // step i.e. -ve index as base case
    int twoStep = minCost(n - 2, costs);
    if (twoStep != Integer.MAX_VALUE) {
      twoStep += (costs[n - 1] + ((n - (n - 2)) * (n - (n - 2))));
    }

    // 3-step jump: (n - 3) -> n
    // if (n - 3 >= 0) { } same reason for 2-step jump
    int threeStep = minCost(n - 3, costs);
    if (threeStep != Integer.MAX_VALUE) {
      threeStep += (costs[n - 1] + ((n - (n - 3)) * (n - (n - 3))));
    }

    return Integer.min(Integer.min(oneStep, twoStep), threeStep);
  }

  // Memorization version
  // TC: O(n) SC: O(n+n)
  private int minCostMemo(int n, int[] costs, int[] dp) {

    // For invalid step we return max cost
    if (n < 0) {
      return Integer.MAX_VALUE;
    }

    // For step at 0 we give cost to 0
    if (n == 0) {
      return 0;
    }

    if (dp[n] != -1) {
      return dp[n];
    }

    // 1-step jump: (n - 1) -> n
    int oneStep = minCostMemo(n - 1, costs, dp);
    if (oneStep != Integer.MAX_VALUE) {
      oneStep += (costs[n - 1] + (1 * 1));
    }

    // 2-step jump: (n - 2) -> n
    // if (n - 2 >= 0) { } we don't need this because, we are handling for out of
    // step i.e. -ve index as base case
    int twoStep = minCostMemo(n - 2, costs, dp);
    if (twoStep != Integer.MAX_VALUE) {
      twoStep += (costs[n - 1] + ((n - (n - 2)) * (n - (n - 2))));
    }

    // 3-step jump: (n - 3) -> n
    // if (n - 3 >= 0) { } same reason for 2-step jump
    int threeStep = minCostMemo(n - 3, costs, dp);
    if (threeStep != Integer.MAX_VALUE) {
      threeStep += (costs[n - 1] + ((n - (n - 3)) * (n - (n - 3))));
    }

    int minStepCost = Integer.min(Integer.min(oneStep, twoStep), threeStep);
    dp[n] = minStepCost;

    return minStepCost;
  }

  // Tabulation version
  // TC: O(n) SC: O(n)
  private int minCostTabu(int n, int[] costs) {

    // For invalid step we return max cost
    if (n < 0) {
      return Integer.MAX_VALUE;
    }

    // For step at 0 we give cost to 0
    if (n == 0) {
      return 0;
    }

    int[] dp = new int[n + 1];
    // Arrays.fill(dp, 0);

    dp[0] = 0;
    // dp[1] = costs[0];

    // n = 8
    // cost: [1, 2, 3, 5, 2, 1, 5, 9]
    // 1-base-index: 1 2 3 4 5 6 7 8
    // dp[]: [0 1 ]

    // From step 1 -> 2 we can move by 1step jump only
    // 0 1 step we know the cost, now we have to build the cost for step 2 to n
    for (int i = 1; i <= n; i++) {

      // 1-step jump is jump from i-1 -> i
      // dp[i-1] I get to know the cost and to reach form dp[i-1] to dp[i] we need to
      // calculate the cost from i-1 to i
      // The destination is step i, so its cost is costs[i-1] (we are doing i-1 in
      // costs because of 1 based-indexing)
      int step1 = dp[i - 1] + (costs[i - 1] + 1 * 1);
      int minCost = step1;

      // 2-step jump from i-2 -> i
      if (i >= 2) {
        // The destination is still step i, therefore costs[i-1]
        int step2 = dp[i - 2] + (costs[i - 1] + 2 * 2);

        // min cost b/w step1 and step2 jump
        minCost = Integer.min(step1, step2);
      }

      // 3-step jump from i-3 -> i
      if (i >= 3) {
        // The destination is still step i, therefore costs[i-1]
        int step3 = dp[i - 3] + (costs[i - 1] + 3 * 3);

        // min cost from the min of step1 & step2
        minCost = Integer.min(minCost, step3);
      }

      dp[i] = minCost;
    }

    return dp[n];
  }

  // Space Optimization
  // TC: O(n) SC: O(1)
  private int minCostSpaceOpt(int n, int[] costs) {

    // For invalid step we return max cost
    if (n < 0) {
      return Integer.MAX_VALUE;
    }

    // For step at 0 we give cost to 0
    if (n == 0) {
      return 0;
    }

    // These represent the previous DP states:
    // jump1 = dp[i-1]
    // jump2 = dp[i-2]
    // jump3 = dp[i-3]
    int jump1 = 0; // dp[0]
    int jump2 = Integer.MAX_VALUE;
    int jump3 = Integer.MAX_VALUE;

    for (int i = 1; i <= n; i++) {

      // 1-step jump from i-1 -> i
      // jump1 currently represents dp[i-1]
      int step1 = jump1 + (costs[i - 1] + 1 * 1);

      int minCost = step1;

      // 2-step jump from i-2 -> i
      if (i >= 2) {
        // jump2 currently represents dp[i-2]
        int step2 = jump2 + (costs[i - 1] + 2 * 2);

        // min cost b/w step1 and step2 jump
        minCost = Integer.min(minCost, step2);
      }

      // 3-step jump from i-3 -> i
      if (i >= 3) {
        // jump3 currently represents dp[i-3]
        int step3 = jump3 + (costs[i - 1] + 3 * 3);

        // min cost from the min of step1 & step2
        minCost = Integer.min(minCost, step3);
      }

      // Shift previous DP values for the next iteration
      // Before:
      // jump1 = dp[i-1]
      // jump2 = dp[i-2]
      // jump3 = dp[i-3]
      //
      // After:
      // jump1 = dp[i]
      // jump2 = dp[i-1]
      // jump3 = dp[i-2]
      jump3 = jump2;
      jump2 = jump1;
      jump1 = minCost;
    }

    return jump1;
  }

}