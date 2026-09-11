package org.example.neetcode.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode head =
                new ListNode(1,
                                new ListNode(2,
                                        new ListNode(4)));



        // Creating Linked List: [0,1,2,3]
        ListNode head2 =
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(5)));

        ListNode head3 =
                        new ListNode(3,
                                new ListNode(6));
        printList(mergeKLists(new ListNode[]{head,head2,head3}));

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(Objects.isNull(lists) || lists.length==0)
            return null;
        while (lists.length>1) {
            List<ListNode> mergedNode=new ArrayList<>();
            for (int i = 0; i < lists.length; i+=2) {
                ListNode list1 = lists[i];
                ListNode list2 = (i+1)<lists.length?lists[i+1]:null;
                mergedNode.add(mergeTwoLists(list1, list2));
               // printList(mergeTwoLists(list1,list2));
            }
            lists=mergedNode.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode node=dummy;

        while (list1!=null && list2 !=null){
            if(list1.val<list2.val){
                node.next=new ListNode(list1.val);
                list1=list1.next;
            }
            else {
                node.next=new ListNode(list2.val);
                list2=list2.next;
            }
            node=node.next;
        }

        if(list1!=null)
            node.next=list1;
        if(list2!=null)
            node.next=list2;
      //  printList(dummy.next);
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

//Input: lists = [[1,2,4],[1,3,5],[3,6]]
//
//Output: [1,1,2,3,3,4,5,6]
//[[1,2,4],[1,3,5],[3,6]]-- We are taking pair and merged one by one
// In the first go we are taking [[1,2,4],[1,3,5]] and merged as [1,1,2,3,4,5] and save in the list
// Now we merge [3,6] and null result-[3,6]
// Now mergedNode list look like [[1,1,2,3,4,5],[3,6]] Now again we are merging and getting result [1,2,3,3,4,5,6]