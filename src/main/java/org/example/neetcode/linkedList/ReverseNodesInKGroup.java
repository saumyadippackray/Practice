package org.example.neetcode.linkedList;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6, new ListNode(7)))))));
       printList(reverseKGroup(head,3));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
        ListNode groupPrv=dummy;

        while (true){
            ListNode kthNode=findKthNode(groupPrv,k);
            if(kthNode==null)
                break;

            ListNode nextNode=kthNode.next;

            ListNode prev=kthNode.next;
            ListNode curr=groupPrv.next;

            while (curr!=nextNode){
                ListNode next= curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }

            ListNode temp=groupPrv.next;
            //we are are taking the groupPrv.next into a temp variable. It will be 1 -> 4 -> 5 -> 6 -> 7 ->. So next time it will start from 4
            printList(groupPrv.next);
            groupPrv.next=prev;
            // connect previous group to new head
            printList(kthNode);
            groupPrv=temp;// move groupPrev to the end of reversed group

        }
        return dummy.next;
    }

    public static ListNode findKthNode(ListNode head,int k){
        while (head != null && k>0){
            head=head.next;
            k--;
        }
        return head;
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
//Input: head = [1,2,3,4,5,6], k = 3
//
//        Output: [3,2,1,6,5,4]
// 1->2->3
//1<-2