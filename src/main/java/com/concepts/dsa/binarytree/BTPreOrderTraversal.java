package com.concepts.dsa.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BTPreOrderTraversal {

    public void preOrderRecursive(BinaryTreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);
        preOrderRecursive(node.leftNode, list);
        preOrderRecursive(node.rightNode, list);
    }

    public List<Integer> preOrderIterative(BinaryTreeNode node) {
        if (node == null) return new ArrayList<>();

        List<Integer> preOrderList = new ArrayList<>();
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.pop();

            preOrderList.add(curr.val);

            if (curr.rightNode != null) {
                stack.push(curr.rightNode);
            }

            if (curr.leftNode != null) {
                stack.push(curr.leftNode);
            }
        }

        return preOrderList;
    }
}
