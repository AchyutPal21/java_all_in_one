package com.concepts.dsa.binarytree;

import java.util.List;

public class BTPostOrderTraversal {

    public void postOrderRecursive(BinaryTreeNode node, List<Integer> list) {
        if (node == null) return;

        postOrderRecursive(node.leftNode, list);
        postOrderRecursive(node.rightNode, list);
        list.add(node.val);
    }
}
