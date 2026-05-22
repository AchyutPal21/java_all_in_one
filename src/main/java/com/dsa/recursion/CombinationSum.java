package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
  private void findCombinationSum(int[] candidates, List<List<Integer>> bucket, List<Integer> container, int idx, int target) {

    if (idx >= candidates.length) {
      return;
    }

    if (target < 0) {
      return;
    }

    if (target == 0) {
      List<Integer> list = new ArrayList<>(container);
      bucket.add(list);
      return;
    }

    
    if (candidates[idx] <= target) {
      container.add(candidates[idx]);
      findCombinationSum(candidates, bucket, container, idx, target - candidates[idx]);
      container.remove(container.size() - 1);
    }

    findCombinationSum(candidates, bucket, container, idx + 1, target);
  }
  
  public List<List<Integer>> solve(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> container = new ArrayList<>();
    int idx = 0;
    findCombinationSum(candidates, list, container, idx, target);
    return  list;
  }


}
