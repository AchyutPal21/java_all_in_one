package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*

CLIMBING STAIRS:

You need to find the distinct outputs for climbing stairs form 0th position to nth position
at a time you can step 1 or 2 stairs at a time.

n = 3
output = 3
Exp: (1 1 1), (1, 2), (2, 1)


*/

public class ClimbingStairs {
  public int solve(int n) {
    List<Integer> dp = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      dp.add(-1);
    }

    return countStepsDP(n, dp);
  }

  private int countSteps(int n) {
    if (n < 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }


    return countSteps(n-1) + countSteps(n-2);
  }

  private int countStepsDP(int n, List<Integer> dp) {
    if (n < 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }

    if (dp.get(n) != -1) {
      return dp.get(n);
    }

    int stepOne = countStepsDP(n-1, dp);
    int stepTwo = countStepsDP(n-2, dp);

    dp.set(n, stepOne+stepTwo);


    return stepOne+stepTwo;
  }

  public int countStepOpt(int n) {
    if (n < 0) return 0;
    if (n == 0) return 1;

    int prev1 = 1;
    int prev2 = 1;

    int curr = 0;
    for (int i = 2; i <= n; i++) {
      curr = prev1 + prev2;
      prev1 = prev2;
      prev2 = curr;
    }

    return curr;
  }

}
