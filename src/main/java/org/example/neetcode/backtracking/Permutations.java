package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> permutations=new ArrayList<>();
        //Arrays.sort(candidates);
        getAllPermutations(nums,result,permutations,new boolean[nums.length]);
        System.out.println(result);
        return result;
    }

    public static void getAllPermutations(int[] nums, List<List<Integer>> result,List<Integer> permutations,boolean[] pick){
        if(permutations.size()>=nums.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!pick[i]){
                pick[i]=true;
                permutations.add(nums[i]);
                getAllPermutations(nums,result,permutations,pick);
                permutations.remove(permutations.size()-1);
                pick[i]=false;
            }
        }
    }

}
