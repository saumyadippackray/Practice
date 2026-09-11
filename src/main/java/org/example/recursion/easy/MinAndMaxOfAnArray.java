package org.example.recursion.easy;

import java.util.ArrayList;

public class MinAndMaxOfAnArray {
    public static void main(String[] args) {
        MinAndMaxOfAnArray minAndMaxOfAnArray=new MinAndMaxOfAnArray();
        int[] nums={19,4,1,5,90,59};
        System.out.println(minAndMaxOfAnArray.findMinMaxRec(nums,nums.length-1));
    }

    public ArrayList<Integer> findMinMaxRec(int[] arr, int index) {
        if(index==0) {
            ArrayList<Integer> minMax = new ArrayList<>();
            minMax.add(arr[0]);
            minMax.add(arr[0]);
            return minMax;
        }
        ArrayList<Integer> minMax=findMinMaxRec(arr,index-1);
        if(arr[index]>minMax.get(0))
            minMax.set(0,arr[index]);
        else if(arr[index]<minMax.get(1))
            minMax.set(1,arr[index]);

        return minMax;

    }
}
