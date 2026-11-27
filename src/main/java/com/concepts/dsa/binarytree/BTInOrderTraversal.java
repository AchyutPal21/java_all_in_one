package com.concepts.dsa.binarytree;


public class BTInOrderTraversal {

    public void inOrderRecursive(BinaryTreeNode node) {
        if (node == null) return;

        inOrderRecursive(node.leftNode);
        System.out.print(node.val + " ");
        inOrderRecursive(node.rightNode);
    }
}
