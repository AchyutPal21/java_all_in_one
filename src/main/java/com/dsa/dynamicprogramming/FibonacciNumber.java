package com.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciNumber {
  public int solve(int n) {
    List<Integer> dp = new ArrayList<>();

    for (int i = 0; i <= n; i++) {
      dp.add(-1);
    }

    return fibo(n, dp);
  }

  private int fibo(int n, List<Integer> dp) {
    if (n == 0) {
      dp.set(n, 0);
      return 0;
    }
    if (n == 1) {
      dp.set(n, 1);
      return 1;
    }

    if (dp.get(n) != -1) {
      return  dp.get(n);
    }

    int r1 = fibo(n-1, dp);
    int r2 = fibo(n-2, dp);

    dp.set(n, r1 + r2);
    

    return r1 + r2;


  }

  public int tabulation(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    return  dp[n];
  }
  

  public int tabulationImproved(int n) {
    if (n <= 2) return n;

    int a = 0;
    int b = 1; 
    int c = 0;
    for (int i = 3; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return  c;
  }



}
