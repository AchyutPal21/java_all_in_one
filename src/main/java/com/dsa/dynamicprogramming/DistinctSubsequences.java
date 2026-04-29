package com.dsa.dynamicprogramming;

// [LeetCode][https://leetcode.com/problems/distinct-subsequences/description/]

public class DistinctSubsequences {
  private int solve(
    StringBuilder strBuilder, String s, String t, int idx) {
    if (idx >= s.length()) {
      if (strBuilder.toString().equals(t)) {
        return  1;
      }

      return 0;
    }

    // Pick the character
    strBuilder.append(s.charAt(idx));
    int included = solve(strBuilder, s, t, idx + 1);

    // Backtrack
    strBuilder.deleteCharAt(strBuilder.length() - 1);

    // Not pick the character
    int excluded = solve(strBuilder, s, t, idx + 1);

    return  included + excluded;

  }


  public int numDistinct(String s, String t) {
    StringBuilder strBuilder = new StringBuilder();
    return  solve(strBuilder, s, t, 0);
  }
}
