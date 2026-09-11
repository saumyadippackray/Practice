package org.example.neetcode.heapPriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();

        for(int num:nums){
            priorityQueue.offer(num);
            if(priorityQueue.size()>k)
                priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
