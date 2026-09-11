package org.example.neetcode.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(ContainerWithMostWater.maxArea(new int[]{1,7,2,5,4,7,3,6}));
    }
    public static int maxArea(int[] heights) {
        int result=0;
        int firstPointer=0;
        int secondPointer=heights.length-1;

        while (secondPointer>firstPointer){
            int contain=Math.min(heights[firstPointer],heights[secondPointer])*(secondPointer-firstPointer);

            result=Math.max(contain,result);
            if(heights[firstPointer]<=heights[secondPointer])
                firstPointer++;
            else secondPointer--;

        }
        return result;
    }
}

//[1,7,2,5,4,7,3,6]
//we have to use two pointer and move the smaller pointer
//