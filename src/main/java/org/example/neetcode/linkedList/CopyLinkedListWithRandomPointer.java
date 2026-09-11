package org.example.neetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {
    public static void main(String[] args) {

        // Create original list:
        // 1 -> 2 -> 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        // Setting random pointers
        n1.random = n3;  // 1 → 3
        n2.random = n1;  // 2 → 1
        n3.random = n2;  // 3 → 2

        //System.out.println("Original List:");
       // printList(n1);

        Node copied = copyRandomList(n1);

        //System.out.println("Copied List:");
       // printList(copied);

        // Modify original to verify deep copy
        n1.val = 100;
        n1.random = null;

        //System.out.println("After modifying original:");
        //System.out.println("Original:");
       //printList(n1);

        //System.out.println("Copied (should NOT change):");
        //printList(copied);
    }
    public static Node copyRandomList(Node head) {
        Map<Node,Node> oldToCopy=new HashMap<>();
        oldToCopy.put(null,null);

        Node curr=head;

        while (curr!=null){
            if(!oldToCopy.containsKey(curr)){
                oldToCopy.put(curr,new Node(0));
            }
            oldToCopy.get(curr).val=curr.val;
            if(!oldToCopy.containsKey(curr.next)){
                oldToCopy.put(curr.next,new Node(0));
            }
            oldToCopy.get(curr).next=oldToCopy.get(curr.next);
            if(!oldToCopy.containsKey(curr.random)){
                oldToCopy.put(curr.random,new Node(0));
            }
            oldToCopy.get(curr).random=oldToCopy.get(curr.random);
            printList(oldToCopy.get(curr));
            curr=curr.next;
        }
        printList(oldToCopy.get(head));
        return oldToCopy.get(head);
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int nextVal = (curr.next != null) ? curr.next.val : -1;
            int randomVal = (curr.random != null) ? curr.random.val : -1;

            System.out.println(
                    "Node(" + curr.val +
                            ") -> next: " + nextVal +
                            ", random: " + randomVal
            );

            curr = curr.next;
        }
        System.out.println("-----------------------");
    }

}
