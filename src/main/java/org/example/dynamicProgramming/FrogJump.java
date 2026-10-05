package org.example.dynamicProgramming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr=new int[]{30,10,60,10,60,50};
        FrogJump frogJump=new FrogJump();
        System.out.println(frogJump.minCostBottomUpWithOutCacheArray(arr));
    }

    public int minCost(int[] height) {
        int[] cache=new int[height.length];
        Arrays.fill(cache,-1);
        return dfs(height,height.length-1,cache);
    }

    public int dfs(int[] arr,int i,int[] cache){
       if(i==0)
           return 0;

       if(cache[i]!=-1)
           return cache[i];
       int left=dfs(arr,i-1,cache)+Math.abs(arr[i]-arr[i-1]);
       int right=Integer.MAX_VALUE;
       if(i>1){
          // System.out.println(right);
           right=dfs(arr,i-2,cache)+Math.abs(arr[i]-arr[i-2]);
           //System.out.println("After"+right);
       }
        return cache[i]=Math.min(left,right);
    }

    public int minCostBottomUp(int[] height) {
        int[] cache=new int[height.length];
        cache[0]=0;
        for(int i=1;i<height.length;i++){
            //System.out.println(height[i]);
            int firstStep=cache[i-1]+Math.abs(height[i]-height[i-1]);
            int secondStep=Integer.MAX_VALUE;
            if(i>1){
                secondStep=cache[i-2]+Math.abs(height[i]-height[i-2]);
            }
            cache[i]=Math.min(firstStep,secondStep);
        }
        return cache[height.length-1];
    }

    public int minCostBottomUpWithOutCacheArray(int[] height) {
//        int[] cache=new int[height.length];
        //cache[0]=0;
        int secondPrev=0;
        int firstPrev=0;
        int curr=0;
        for(int i=1;i<height.length;i++){
            //System.out.println(height[i]);
            int firstStep=firstPrev+Math.abs(height[i]-height[i-1]);
            int secondStep=Integer.MAX_VALUE;
            if(i>1){
                secondStep=secondPrev+Math.abs(height[i]-height[i-2]);
            }
            secondPrev=firstPrev;
            firstPrev=Math.min(firstStep,secondStep);

        }
        return firstPrev;
    }
}
