package com.concepts.dsa.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(BinaryTreeNode node) {
        if (node == null) return new ArrayList<>();

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();

        List<List<Integer>> lvlList = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> lvlNodes = new ArrayList<>();
            int currLvlNodes = queue.size();
            int countNodes = 0; // Count till previous queue size

            while (countNodes < currLvlNodes) {
                BinaryTreeNode curr = queue.remove();

                if (curr.leftNode != null) {
                    queue.add(curr.leftNode);
                }

                if (curr.rightNode != null) {
                    queue.add(curr.rightNode);
                }

                countNodes++;
                lvlNodes.add(curr.val);
            }
            
            lvlList.add(lvlNodes);
        }

        return lvlList;


    }
}
