package org.example.neetcode.linkedList;

import java.util.List;

public class ReverseLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static void main(String[] args) {

        ReverseLinkedList rll = new ReverseLinkedList();

        // Creating Linked List: [0,1,2,3]
        ReverseLinkedList.ListNode head =
                rll.new ListNode(0,
                        rll.new ListNode(1,
                                rll.new ListNode(2,
                                        rll.new ListNode(3))));

        // Reversing the list
        ReverseLinkedList.ListNode reversedHead = rll.reverseList(head);

        // Printing reversed list
        printList(reversedHead);
    }
    private static void printList(ReverseLinkedList.ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public ListNode reverseList(ListNode head) {
        ListNode previous=null;
        while (head!=null){
            ListNode nextNode=head.next;
            head.next=previous;
            previous=head;
            head=nextNode;
        }
        return previous;
    }
}

//Input: head = [0,1,2,3]
//
//        Output: [3,2,1,0]
// null  [0,1,2,3]
// 0     0 ->1 2 3
