package org.example.neetcode.linkedList;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        MergeTwoSortedLinkedLists rll = new MergeTwoSortedLinkedLists();

        // Creating Linked List: [0,1,2,3]
        ListNode head =
                new ListNode(10,
                                new ListNode(11,
                                       new ListNode(12,
                                               new ListNode(13, new ListNode(14)))));



        // Creating Linked List: [0,1,2,3]
        ListNode head2 =
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(5)));
        ListNode reversedHead = rll.mergeTwoLists(head,head2);

        // Printing reversed list
        printList(reversedHead);
    }
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        printList(dummy.next);
        return dummy.next;
    }
  }


//Input: list1 = [1,2,4], list2 = [1,3,5]
//
//        Output: [1,1,2,3,4,5]
// 1,1,2,3,4,5

//    You must NOT move dummy, otherwise you will lose the head of the merged list.
//
//        But inside the loop you do:
//
//        node = node.next;
//
//
//        If you wrote:
//
//        dummy = dummy.next;
//
//
//        you would lose the pointer to the beginning, and later you couldn’t return the merged list:
//
//        return dummy.next;  // would be wrong because dummy moved
//
//
//        So we keep:
//
//        dummy → always at start
//
//        node → moves forward and builds the list
//
//        ✅ Reason 2 — One pointer builds, one pointer returns
//        node
//
//        Used for building:
//
//        node.next = ...
//        node = node.next;
//
//        dummy
//
//        Used only at the end:
//
//        return dummy.next; // head of merged list
//
//
//        If you used only dummy for build + return, you wouldn’t know where the head is.
//
//        🔥 Memory diagram (easy to visualize)
//        dummy (fixed) → [0] → [ ? ] → [ ? ] → ...
//        ^
//        /
//        node (moving)
//
//
//        After merging:
//
//        dummy → 0 → 1 → 2 → 4 → 5
//        return dummy.next --> 1
//
//
//        If you moved dummy:
//
//        dummy moved ----> 1 → 2 → ...
//        Now you lost the real start.


