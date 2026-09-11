package org.example.neetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(LargestRectangleInHistogram.largestRectangleArea(new int[]{2,1,5,6,2,20}));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<int[]> heightAndIndexStack=new Stack<>();//in the 0th index we will take the index and in the 1st index save height

        for(int i=0;i<heights.length;i++){
            if(heightAndIndexStack.isEmpty()){
                heightAndIndexStack.push(new int[]{i, heights[i]});
            }
            else{
                int newStartingIndex=i;
                while (!heightAndIndexStack.isEmpty() && heightAndIndexStack.peek()[1]>heights[i]){
                    int area=(i-heightAndIndexStack.peek()[0])*heightAndIndexStack.peek()[1];
                    maxArea=Math.max(area,maxArea);
                    newStartingIndex=heightAndIndexStack.peek()[0];
                    heightAndIndexStack.pop();
                }
                heightAndIndexStack.push(new int[]{newStartingIndex,heights[i]});
            }
        }

        while (!heightAndIndexStack.isEmpty()){
            int area=(heights.length-heightAndIndexStack.peek()[0])*heightAndIndexStack.peek()[1];
            maxArea=Math.max(area,maxArea);
            heightAndIndexStack.pop();
        }
        return maxArea;
    }
}

// [2,1,5,6,2,3]
//
