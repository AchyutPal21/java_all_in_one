package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
  private  void merge(List<Integer> arr, int low, int mid, int high) {
    // Variables
    int p = low;
    int q = mid + 1;

    // Temp array container
    List<Integer> temp = new ArrayList<>();

    // Add the smallest index value into temp array
    while (p <= mid && q <= high) {
      if (arr.get(p) <= arr.get(q)) {
        temp.add(arr.get(p));
        p++;
      } else {
        temp.add(arr.get(q));
        q++;
      }
    }

    // Fill remaining elements from index p
    while (p <= mid) {
      temp.add(arr.get(p++));
    }

    while (q <= high) {
      temp.add(arr.get(q++));
    }

    // Now fill the temp value back into arr
    for (int k = low; k <= high; k++) {
      arr.set(k, temp.get(k - low));
    }
  }


  public void sort(List<Integer> list, int low, int high) {
    if (low >= high) {
      return;
    }

    int mid = low + ((high - low) / 2);
    sort(list, low, mid);
    sort(list, mid + 1, high);
    merge(list, low, mid, high);

  }
}
