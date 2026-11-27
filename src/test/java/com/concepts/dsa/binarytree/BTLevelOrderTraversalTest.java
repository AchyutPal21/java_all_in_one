package com.concepts.dsa.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BTLevelOrderTraversalTest {

    private BTLevelOrderTraversal traversal;

    @BeforeEach
    void setUp() {
        traversal = new BTLevelOrderTraversal();
    }

    @Test
    void levelOrder_shouldReturnEmptyList_whenRootIsNull() {
        List<List<Integer>> result = traversal.levelOrder(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void levelOrder_shouldReturnSingleLevel_whenTreeHasOnlyRoot() {
        BinaryTreeNode root = node(42, null, null);

        List<List<Integer>> result = traversal.levelOrder(root);

        assertEquals(List.of(List.of(42)), result);
    }

    @Test
    void levelOrder_shouldGroupNodesByLevel_forStandardBinaryTree() {
        //        3
        //       / \
        //      9  20
        //        /  \
        //       15   7
        BinaryTreeNode root = node(
                3,
                node(9, null, null),
                node(20, node(15, null, null), node(7, null, null))
        );

        List<List<Integer>> result = traversal.levelOrder(root);

        List<List<Integer>> expected = List.of(
                List.of(3),
                List.of(9, 20),
                List.of(15, 7)
        );
        assertEquals(expected, result);
    }

    @Test
    void levelOrder_shouldHandleUnbalancedAndNegativeValues() {
        //        -1
        //       /
        //     -5
        //       \
        //        10
        BinaryTreeNode root = node(
                -1,
                node(-5, null, node(10, null, null)),
                null
        );

        List<List<Integer>> result = traversal.levelOrder(root);

        List<List<Integer>> expected = List.of(
                List.of(-1),
                List.of(-5),
                List.of(10)
        );
        assertEquals(expected, result);
    }

    // Small test-only helper to build trees readably inside tests
    private BinaryTreeNode node(int val, BinaryTreeNode left, BinaryTreeNode right) {
        BinaryTreeNode n = new BinaryTreeNode();
        n.val = val;
        n.leftNode = left;
        n.rightNode = right;
        return n;
    }
}