package com.concepts.dsa.binarytree;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;
    
    public BinaryTreeNode() {}

    public BinaryTreeNode(int val) {
        this.val = val;
        this.leftNode = null;
        this.rightNode = null;
    }
    
    public BinaryTreeNode (int val, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;     
    }
}
