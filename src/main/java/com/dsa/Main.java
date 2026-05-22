package com.dsa;

import com.dsa.linkedlist.LinkedList;
import com.dsa.linkedlist.SinglyNode;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // ==============================
        // TEST 1: Pop from empty list
        // ==============================
        System.out.println("TEST 1: Pop from empty list");

        SinglyNode popped1 = list.pop();

        System.out.println(
            popped1 == null
                    ? "PASS: Returned null"
                    : "FAIL");

        list.print();

        // ==============================
        // TEST 2: Push single node
        // ==============================
        System.out.println("\nTEST 2: Push single node");

        list.push(new SinglyNode(10));

        list.print();

        // Expected:
        // 10

        // ==============================
        // TEST 3: Pop single node
        // ==============================
        System.out.println("\nTEST 3: Pop single node");

        SinglyNode popped2 = list.pop();

        System.out.println(
                popped2 != null
                        ? "Popped: " + popped2.value
                        : "FAIL");

        list.print();

        // Expected:
        // Popped: 10
        // empty list

        // ==============================
        // TEST 4: Push multiple nodes
        // ==============================
        System.out.println("\nTEST 4: Push multiple nodes");

        list.push(new SinglyNode(10));
        list.push(new SinglyNode(20));
        list.push(new SinglyNode(30));
        list.push(new SinglyNode(40));

        list.print();

        // Expected:
        // 10 20 30 40

        // ==============================
        // TEST 5: Pop from multiple nodes
        // ==============================
        System.out.println("\nTEST 5: Pop from multiple nodes");

        SinglyNode popped3 = list.pop();

        System.out.println(
                popped3 != null
                        ? "Popped: " + popped3.value
                        : "FAIL");

        list.print();

        // Expected:
        // Popped: 40
        // 10 20 30

        // ==============================
        // TEST 6: Multiple pops
        // ==============================
        System.out.println("\nTEST 6: Multiple pops");

        System.out.println("Popped: " + list.pop().value);
        System.out.println("Popped: " + list.pop().value);
        System.out.println("Popped: " + list.pop().value);

        list.print();

        // Expected:
        // Popped: 30
        // Popped: 20
        // Popped: 10

        // ==============================
        // TEST 7: Pop after all removed
        // ==============================
        System.out.println("\nTEST 7: Pop after all removed");

        SinglyNode popped4 = list.pop();

        System.out.println(
                popped4 == null
                        ? "PASS: Returned null"
                        : "FAIL");

        list.print();

        // Expected:
        // PASS: Returned null

        // ==============================
        // TEST 8: Reuse after empty
        // ==============================
        System.out.println("\nTEST 8: Reuse list after empty");

        list.push(new SinglyNode(100));
        list.push(new SinglyNode(200));

        list.print();

        // Expected:
        // 100 200

        // ==============================
        // TEST 9: Pop again
        // ==============================
        System.out.println("\nTEST 9: Final pop");

        System.out.println("Popped: " + list.pop().value);

        list.print();

        // Expected:
        // Popped: 200
        // 100
    }
}