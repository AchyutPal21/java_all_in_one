package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
  private void swap(List<Integer> arr, int i, int j) {
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }


  private int fixPivotPosition(List<Integer> arr, int low, int high) {

    int l = low; 
    int h = high;

    int pivot = l;

    while (l <= h) {
      while (l <= high && arr.get(l) <= arr.get(pivot)) {
        l++;
      }

      while (h >= l && arr.get(h) > arr.get(pivot)) {
        h--;
      }

      if (l < h) {
        swap(arr, l, h);
      }
    }

    swap(arr, pivot, h);

    return  h;
  }


  public void sort(List<Integer> arr, int low, int high) {
    if (low >= high) return;

    int pivot = fixPivotPosition(arr, low, high);
    sort(arr, low, pivot - 1);
    sort(arr, pivot + 1, high);
  }

  public void makeCall() {
    List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(3);
        int low = 0;
        int high = list.size() - 1;
        sort(list, low, high);
        // unsorted: 4 6 2 5 7 9 1 3
        // sorted: 1 2 3 4 5 6 7 9
        System.out.println("Sorted Array:");
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
  }

}
