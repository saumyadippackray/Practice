package org.example.neetcode.linkedList;

public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode head =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(6,
                                    new ListNode(8,
                                        new ListNode(10)))));
        reorderList(head);
    }
    public static void reorderList(ListNode head) {
        ListNode slowNode=head;
        ListNode fastNode=head.next;

        while (fastNode!=null && fastNode.next!=null){
            slowNode= slowNode.next;
            fastNode=fastNode.next.next;
        }

        ListNode secondNode=slowNode.next;
        slowNode.next=null;
        ListNode previousNode=null;

        while (secondNode!=null){
            ListNode next=secondNode.next;
            secondNode.next=previousNode;
            previousNode=secondNode;
            secondNode=next;
        }

        secondNode=previousNode;
        ListNode firstNode=head;
        printList(firstNode);
        printList(secondNode);

        while (secondNode!=null)
        {
            ListNode firstNextNode=firstNode.next;
            ListNode secondNextNode=secondNode.next;

            firstNode.next=secondNode;
            secondNode.next=firstNextNode;

            secondNode=secondNextNode;
            firstNode=firstNextNode;
        }
        printList(head);
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


//Input: head = [2,4,6,8,10]
//
//        Output: [2,10,4,8,6]

// 2 4       6 8 10
// 2 10