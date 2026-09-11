package org.example.neetcode.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        twoSum.twoSum(new int[]{3,4,5,6},7);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> twoSumMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(twoSumMap.containsKey(diff))
                return new int[]{twoSumMap.get(diff),i};
            twoSumMap.put(nums[i],i);
        }
        return new int[]{};
    }
}

