package org.example.neetcode.twopointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(TrappingRainWater.trap(new int[]{0,2,0,3,1,0,1,3,2,1}));
    }
    public static int trap(int[] height) {
        int maxRight=0;
        int maxLeft=0;
        int firstPointer=0;
        int secondPointer=height.length-1;
        int totalWaterTrap=0;

        while (secondPointer>firstPointer){
            if(firstPointer==0)
                maxLeft=height[firstPointer];
            if(secondPointer==height.length-1)
                maxRight=height[secondPointer];

            if(height[firstPointer]<=height[secondPointer]){
                if((Math.min(maxRight,maxLeft)-height[firstPointer])>0) {
                    totalWaterTrap = totalWaterTrap + (Math.min(maxRight, maxLeft) - height[firstPointer]);
                }
                firstPointer++;
            }
            else {
                if(Math.min(maxRight,maxLeft)-height[secondPointer]>0) {
                    totalWaterTrap = totalWaterTrap + (Math.min(maxRight, maxLeft) - height[secondPointer]); }
                    secondPointer--;

            }
            if(height[firstPointer]>maxLeft) maxLeft=height[firstPointer];
            if(height[secondPointer]>maxRight) maxRight=height[secondPointer];
        }
        return totalWaterTrap;
    }
}
// [0,2,0,3,1,0,1,3,2,1]
// ->0 2 0 3 1 0 1 3 2 ->1 maxLeft=0 maxRight=1
//  0 ->2 0 3 1 0 1 3 2 ->1 maxLeft=0 maxRight=1 waterTrap=Min(maxLeft,maxRight)-i = -1 new maxLeft=2
// 0 ->2 0 3 1 0 1 3 ->2 1  maxLeft=2 maxRight=1 wt=-1