package org.example.neetcode.twopointer;

import org.example.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeIntegerSun {
    public static void main(String[] args) {
        ThreeIntegerSun.threeSum(new int[]{-1,0,1,2,-1,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i-1]==nums[i]){
                continue;
            } else if (nums[i]>0) {
                break;
            } else {
                int firstPointer=i+1;
                int secondPointer= nums.length-1;
                while (secondPointer>firstPointer){
                    if(nums[i]+nums[firstPointer]+nums[secondPointer]>0)
                        secondPointer--;
                    else if(nums[i]+nums[firstPointer]+nums[secondPointer]<0)
                        firstPointer++;
                    else if (nums[i]+nums[firstPointer]+nums[secondPointer]==0) {
                        result.add(Arrays.asList(nums[i],nums[firstPointer],nums[secondPointer]));
                        firstPointer++;
                        secondPointer--;
                        while (firstPointer < secondPointer && nums[firstPointer] == nums[firstPointer - 1]) {
                            firstPointer++;
                        }
                    }
                }
            }
        }
        return result;
    }
}

//-3 3 4 -3 1 2
//We have to sort the array
//-3 -3 1 2 3 4
//We will skip the index if i+1 is same value as i
// after that we will apply two integer sun algo
//keep looking for more pair

//[-1,0,1,2,-1,-4]
//[-4,-1,-1,0,1,2]
//l++;
//                    r--;
//                    while (l < r && nums[l] == nums[l - 1]) {
//                        l++;
//                    }