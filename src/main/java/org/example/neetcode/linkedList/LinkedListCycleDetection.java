package org.example.neetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {
    public static void main(String[] args) {
        //MergeTwoSortedLinkedLists rll = new MergeTwoSortedLinkedLists();

        // Creating Linked List: [0,1,2,3]
        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(4)));

        System.out.println(hasCycle(head));
    }
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> listNodes=new HashSet<>();
        while (head!=null){
            listNodes.add(head);
            head=head.next;
            if (listNodes.contains(head)) {
                return true;
            }
        }


        return false;
    }
}
