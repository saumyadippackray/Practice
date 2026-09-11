package org.example.neetcode.linkedList;

public class Node {
    int val;
    Node next;
    Node random;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val,Node next) { this.val = val; this.next = next; }
    Node(int val,Node next,Node random) { this.val = val; this.next = next; this.random=random;}
}
