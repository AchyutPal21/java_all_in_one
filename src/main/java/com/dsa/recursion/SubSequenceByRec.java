package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;


public class SubSequenceByRec {
  private  void printSubsequence(List<Integer> list, List<Integer> bucketList, int idx) {
    if (idx >= list.size()) {
      if (bucketList.isEmpty()) {
        System.out.println("[]");
      } else {
        System.out.print("[");
        for (int num : bucketList) {
          System.out.print(num + " ");
        }
        System.out.print("]\n");
      }
      return;
    }

    // Pick
    bucketList.add(list.get(idx));
    printSubsequence(list, bucketList, idx+1);
    
    // Backtrack
    bucketList.remove(bucketList.size()-1);

    // Not pick
    printSubsequence(list, bucketList, idx+1);
  }

  public void solve(List<Integer> list) {
    List<Integer> bucketList = new ArrayList<>();
    printSubsequence(list, bucketList, 0);
  }
}
