package org.example.neetcode.linkedList;

public class RemoveNodeFromEndofLinkedList {
    public static void main(String[] args) {
        ListNode head =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(6,
                                        new ListNode(8,
                                                new ListNode(10)))));
        removeNthFromEnd(head,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy;
        ListNode rightNode=head;
        for(int i=0;i<n;i++){
            rightNode=rightNode.next;
        }
        while (rightNode!=null){
            rightNode=rightNode.next;
            leftNode=leftNode.next;
        }

//        leftNode.next=leftNode.next.next;
        leftNode.next=leftNode.next.next;
        printList(dummy.next);
        return dummy.next;
    }
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}

//input- 2,4,6,8,10 n=2
//output - 2,3,6,10
// We have to take to two pointer one from stating and one from start+n and increase the pointer by one until the value of 2nd pointer is null;
// ->2 3 ->6 8 10
// 2 ->3 6 ->8 10
// 2 3 ->6 8 ->10
// 2 3 6 ->8 10 -> the value of 2nd pointer is null that's why we have to remove the 8