package com.concepts.linkedlist;

public class SinglyNode {

  public int value;
  public SinglyNode next;

  public SinglyNode(int value) {
    this.value = value;
  }

  public SinglyNode(int value, SinglyNode next) {
    this.value = value;
    this.next = next;
  }
}
