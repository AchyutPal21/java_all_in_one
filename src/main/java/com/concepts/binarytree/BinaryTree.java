package com.concepts.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    private final BinaryTreeNode head;

    public BinaryTree(BinaryTreeNode node) {
        this.head = node;
    }

    public void addLeftNode(BinaryTreeNode parentNode, BinaryTreeNode childNode) {
        parentNode.leftNode = childNode;
    }

    public void addRightNode(BinaryTreeNode parentNode, BinaryTreeNode childNode) {
        parentNode.rightNode = childNode;
    }

    /**
     * Pre-order BT Traversal
     * @param node
     */
    public void preOrderDispRec(BinaryTreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        preOrderDispRec(node.leftNode);
        preOrderDispRec(node.rightNode);
    }

    /**
     * In-order BT Traversal
     * @param node
     */
    public void inOrderDispRec(BinaryTreeNode node) {
        if (node == null) return;

        inOrderDispRec(node.leftNode);
        System.out.print(node.val + " ");
        inOrderDispRec(node.rightNode);
    }

    /**
     * Post-order BT Traversal
     * @param node
     */
    public void postOrderDispRec(BinaryTreeNode node) {
        if (node == null) return;

        postOrderDispRec(node.leftNode);
        postOrderDispRec(node.rightNode);
        System.out.print(node.val + " ");
    }


    /**
     * In-Order BT Iterative Traversal
     */
    public void preOrderDispIter() {
        
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode curr = head;
        stack.push(curr);

        while (!stack.empty()) {
            BinaryTreeNode top = stack.pop();

            System.out.print(top.val + " ");

            if (top.rightNode != null) {
                stack.push(top.rightNode);
            }

            if (top.leftNode != null) {
                stack.push(top.leftNode);
            }
        }
    }

    




}
