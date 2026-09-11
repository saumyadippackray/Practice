package org.example.neetcode.heapPriorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'X','Y','X','Y'},10));
    }
    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        int[] charCount=new int[26];

        for(char c:tasks){
            charCount[c-'A']++;
        }

        for (int i:charCount){
            if (i > 0) {
                maxHeap.offer(i);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while (!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if (maxHeap.isEmpty()) {
                //time = time;// It will work
                time=q.peek()[1]; // it is efficient code. we can jump to the time when cpu is ideal.
                // after insert first y the cpu will ideal upto 11 that's why we can directly jump to 11
            } else {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    q.add(new int[]{count, time + n});
                }
            }
            if(!q.isEmpty() && time==q.peek()[1]){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}

//Input: tasks = ["X","X","Y","Y"], n = 2
//
//Output: 5
//time=1 X   X next=1+2=3
//time=2 XY  Y next=2+2=4
//time=3