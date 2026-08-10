package com.dsa.array.simple;

public class ElementGreaterThenItself {
  public int solve(int[] arr) {
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        count = 1;
      } else {
        count++;
      }
    }

    return  count;
  }
}
