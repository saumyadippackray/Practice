package org.example.neetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum.maxSlidingWindowCorrect(new int[]{1,3,-1,-3,5,3,6,10,1,3,2},3);
    }
    public static int[] maxSlidingWindowCorrect(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer<n){
            while (!q.isEmpty() && q.getLast()<nums[rightPointer]){
                q.removeLast();
            }
            q.add(rightPointer);

            if(leftPointer>q.getFirst()){
                q.removeFirst();
            }

            if(rightPointer+1>=k){
                output[leftPointer]=nums[q.getFirst()];
                leftPointer++;
            }
            rightPointer++;
        }
        return output;
    }

    //1 3 -1 -3 5 3 6 10
    //1                 --
    //3                 -- add 3 and remove 1 because 1 less than 3
    //3 -1              --  length >=k so hv=3 l=1
    //3 -1 -3           --length >=k so hv=3   l=2
    //5                 --remove all elements from last because until 5 is geater so hv=5 l=3
    //5 3               -- hv=5 l=4
    //6                 -- remove all elements from last because until 6 is geater so hv=6 l=5
    //10                 -- remove all elements from last because until 10 is geater so hv=10 l=6
    //10 1               -- hv=10 l=7
    //10 3               -- remove all elements from last because until 3 is geater so hv=10 l=8
    //3 2               -- accuse starting point index was 7 and value was 10 and the left pointer is 8 so index 7 is out of window
                          //thats why we have to remove that element so hv=3 and l=9
    //l = left pointer







    public static int[] maxSlidingWindow(int[] nums, int k) {
        int rightPointer=0;
        int leftPointer=rightPointer+k-1;
        int highestNumber=0;
        int[] highestNumberList=new int[nums.length-k+1];
        int l=0;
       // List<Integer> highestNumberList=new ArrayList<>();
        while (leftPointer<nums.length){
            if(rightPointer==0){
                for(int i=rightPointer;i<=leftPointer;i++){
                    highestNumber=Math.max(highestNumber,nums[i]);
                }
            }
            else{
                if(nums[rightPointer-1]==highestNumber){
                    if(nums[rightPointer-1]<nums[leftPointer])
                        highestNumber=nums[leftPointer];
                }
                else {
                    if(highestNumber<nums[leftPointer])
                        highestNumber=nums[leftPointer];
                }
            }
            rightPointer++;
            leftPointer++;
           highestNumberList[l]=highestNumber;
           l++;
        }
        System.out.println(highestNumberList);
        return highestNumberList;
    }
}

//Input: nums = [1,2,1,0,4,2,6], k = 3
//Output: [2,2,4,4,6]