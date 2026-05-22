package com.dsa.linkedlist;

public class LinkedList {
  private SinglyNode head;
  private SinglyNode tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

public void push(SinglyNode node) {

    if (node == null) {
      return;
    }

    node.next = null;

    if (head == null) {
      head = node;
      tail = node;
      return;
    }

    tail.next = node;
    tail = node;
  }

  public SinglyNode pop() {

    // no nodes
    if (head == null) {
        return null;
    }

    // single node
    if (head.next == null) {
        SinglyNode temp = head;
        head = null;
        tail = null;
        return temp;
    }

    // multiple nodes
    SinglyNode current = head;

    while (current.next != tail) {
        current = current.next;
    }

    SinglyNode removedNode = tail;

    tail = current;
    tail.next = null;

    return removedNode;
  }

  public void print() {
    SinglyNode temp = head;

    while (null != temp) {
      System.out.print(temp.value + " ");
      temp = temp.next;
    }

    System.out.println();
  }

  
}
