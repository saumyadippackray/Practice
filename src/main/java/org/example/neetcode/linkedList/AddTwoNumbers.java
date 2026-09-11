package org.example.neetcode.linkedList;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 =
//                new ListNode(1,
//                        new ListNode(2,
//                                new ListNode(3)));
//        ListNode l2 =
//                new ListNode(4,
//                        new ListNode(5,
//                                new ListNode(6)));
        ListNode l1 =
                new ListNode(9);
        ListNode l2 =
                new ListNode(9);
        printList(addTwoNumbers(l1,l2));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result=dummy;
        int carry=0;

        while (l1!=null || l2!=null || carry!=0){
            result.next=new ListNode(0);
            result=result.next;
            int val1= (l1!=null) ?l1.val:0;
            int val2= (l2!=null) ?l2.val:0;
            int val=val1+val2+carry;
            carry=val/10;
            val=val%10;
            result.val=val;
            l1=(l1!=null) ?l1.next:null;
            l2=(l2!=null) ?l2.next:null;
        }

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
