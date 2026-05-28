package com.dsa.array.simple;

public class FindFactor {
  // brute force method
  // If num mod i equal 0 that is a complete mod
  public int countFactors(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (n%i == 0) {
        count++;
      }
    }
    return count;
  }

  public int countFactorsOpt(int n) {
    int count = 0;

    // i should go till
    //   __
    // _/n  value
    for (int i = 1; i * i <= n; i++) {
      if (n%i == 0) {
        // perfect square
        if (i == n/i) {
          count++;
        } else {
          count += 2;
        }
      }
    }

    return count;
  }
}
