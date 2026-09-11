package org.example.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        int firstIndex=0;
        int secondIndex=0;
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(prevMap.containsKey(diff)) {
                firstIndex = prevMap.get(diff);
                secondIndex=i;
                return new int[]{firstIndex, secondIndex};
            }
            prevMap.put(nums[i],i);

        }
        return null;
    }

    public static void main(String[] args) {
        int nums[]={2,7,11,15};
        System.out.println(twoSum(nums,18)[0]+"---"+twoSum(nums,18)[1]);
    }
}
