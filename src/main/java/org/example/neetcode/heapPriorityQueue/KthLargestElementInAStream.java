package org.example.neetcode.heapPriorityQueue;

import org.example.Queue.Queue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private PriorityQueue<Integer> minHeap;
    private Integer size;

    public static void main(String[] args) {
        KthLargestElementInAStream kthLargestElementInAStream=new KthLargestElementInAStream(3,new int[]{1, 2, 3, 3});
        System.out.println(kthLargestElementInAStream.add(3));
        System.out.println(kthLargestElementInAStream.add(5));
        System.out.println(kthLargestElementInAStream.add(6));
        System.out.println(kthLargestElementInAStream.add(7));
        System.out.println(kthLargestElementInAStream.add(8));
    }
    public KthLargestElementInAStream(int k, int[] nums) {
        minHeap=new PriorityQueue<>();
        size=k;
        for(int num:nums){
            minHeap.offer(num);
            if(minHeap.size()>size){
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size()>size){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
// Use priority queue priority queue always guarantee that the smallest element will be on top root
//1
//1 2
//1 2 3
//1 2 3 3  ---remove 1 because size is size>3
//2 3 3
//---Add 3
//2 3 3 3   --- remove 2 because size is size>3
//3 3 3  --- return 3
//---Add 5
//3 3 3 5  --- remove 3 because size is size>3
//3 3 5   --- rerun 3
//---Add 6
//3 3 5 6
//3 5 6  ---return 3
//---Add 7
//3 5 6 7
//5 6 7 ---return 5
//---Add 8
//5 6 7 8
//6 7 8 --return 6