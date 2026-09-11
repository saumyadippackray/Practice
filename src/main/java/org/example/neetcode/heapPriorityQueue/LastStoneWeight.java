package org.example.neetcode.heapPriorityQueue;

import java.util.Map;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{3,7,2}));

    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(); //2,3,6,2,4

        for(int stone:stones){
            priorityQueue.offer(-stone);
        }
        //-6 -4 -3 -2 -2
        while (priorityQueue.size()>1){
            int x=priorityQueue.poll(); //-6
            int y= priorityQueue.poll(); //-4

            if(y>x){
                y=x-y;
                priorityQueue.offer(y);
            }

        }
        return Math.abs(priorityQueue.peek());
    }
}
