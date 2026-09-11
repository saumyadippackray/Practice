package org.example.neetcode.heapPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream=new FindMedianFromDataStream();
        findMedianFromDataStream.addNum(3);
        findMedianFromDataStream.addNum(2);
        findMedianFromDataStream.addNum(7);
        findMedianFromDataStream.addNum(4);
        System.out.println(findMedianFromDataStream.findMedian());
    }

    private Queue<Integer> smallHeap; //small elements - maxHeap
    private Queue<Integer> largeHeap; //large elements - minHeap
    public FindMedianFromDataStream() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap=new PriorityQueue<>((a,b) -> a-b);
//        if result < 0  →  a comes BEFORE b
//        if result > 0  →  a comes AFTER b
//        if result == 0 →  order doesn't matter
    }

    public void addNum(int num) {
        smallHeap.add(num);

        if(smallHeap.size()>largeHeap.size()+1 || !largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek()){
            //smallHeap.peek()>largeHeap.peek() why this condition because every element of large heap should be greater than
            //than the smallheap
            largeHeap.offer(smallHeap.poll());
        }
        if(largeHeap.size()>smallHeap.size()+1){
            smallHeap.offer(largeHeap.poll());
        }
    }

    public double findMedian() {
        if(smallHeap.size()==largeHeap.size()){
            return (double)(smallHeap.peek()+largeHeap.peek())/2;
        } else if (smallHeap.size()>largeHeap.size()) {
            return (double)smallHeap.peek();
        }
        else {
            return (double)largeHeap.peek();
        }
    }
}
