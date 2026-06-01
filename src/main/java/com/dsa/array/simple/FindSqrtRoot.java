package com.dsa.array.simple;

public class FindSqrtRoot {
  // This is Optimized solution to find the square root of the n in:
  // TC: O(log n) SC: O(1)
  public int solve(int n) {
    if (n <= 0) {
      return 0;
    }

    int low = 1;
    int high = n;
    int mid = 0;
    long square = 1L;
    while (low <= high) {
      mid = low + ((high - low ) / 2);

      square = (long) mid * mid;
      if (square == n) {
        return mid;
      } else if (square > n) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return -1;
  }

}
