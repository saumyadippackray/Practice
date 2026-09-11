package org.example.neetcode.linkedList;

import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
       // ["LRUCache", [2], "put", [1, 1], "put", [2, 2], "get", [1], "put", [3, 3], "get", [2], "put", [4, 4], "get", [1], "get", [3], "get", [4]]
    }
    int capacity;
    LRUNode left;
    LRUNode right;
    HashMap<Integer,LRUNode> cache=new HashMap<>();


    class LRUNode{
        int key;
        int value;

        LRUNode previous;
        LRUNode next;

        public LRUNode(int key, int val) {
            this.key = key;
            this.value = val;
            this.previous = null;
            this.next = null;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        right=new LRUNode(0,0);
        left=new LRUNode(0,0);
        this.left.next=this.right;
        this.right.previous=this.left;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            LRUNode node=cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void insert(LRUNode lruNode){
        LRUNode previous=this.right.previous;  //copy the previous node
        previous.next=lruNode; // set the previous node next to the new node
        lruNode.next=this.right; //new node's right is the right node
        lruNode.previous=previous; //new node's left is the previous node
        this.right.previous=lruNode; // left node previous is the new node
        System.out.println("In insert---"+lruNode.key);
        //printList(left);
    }

    public void remove(LRUNode lruNode){
        System.out.println("in remove node---"+lruNode.key);
        LRUNode next=lruNode.next;
        LRUNode prev=lruNode.previous;

        next.previous=prev;
        prev.next=next;
       // printList(this.left);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        LRUNode lruNode=new LRUNode(key,value);
        cache.put(key,lruNode);
        insert(lruNode);
       // System.out.println(cache);
        //printList(this.left);
        if(cache.size()>capacity){
            System.out.println("Next key"+left.next.key);
            System.out.println(cache.get(left.next.key));
            LRUNode lru = left.next;
            remove(cache.get(lru.key));

            cache.remove(left.key);

        }


    }

    private static void printList(LRUNode head) {
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
