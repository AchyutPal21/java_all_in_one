package com.dsa.recursion;

public class Backtracking {
  public void solve(int n) {
    if (0 == n) return;

    System.out.println(n);
    solve(n-1);
  }
}
