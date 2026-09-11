package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetWithSumCount {
    public static void main(String[] args) {
        subsetsWithSumCount(new int[]{3,1,2,1});
    }
    public static List<List<Integer>> subsetsWithSumCount(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();

        System.out.println(getSubsetsWithSumCount(0,0,subset,nums,3));
        return result;
    }
    public static int getSubsetsWithSumCount(int index,Integer subsetSum,List<Integer> subset,int[] nums,int sum){
        if(index>=nums.length)
        {
            if(subsetSum==sum)
                return 1;
            return 0;
        }

        subset.add(nums[index]);
        subsetSum=subsetSum+nums[index];
        int left=getSubsetsWithSumCount(index+1,subsetSum,subset,nums,sum);
        subsetSum=subsetSum- subset.get(subset.size()-1);
        subset.remove(subset.size()-1);
        int right=getSubsetsWithSumCount(index+1,subsetSum,subset,nums,sum);
        return left+right;
    }
}

//1️⃣ Focus ONLY on RIGHT branch of index 0
//
//From root:
//
//f(0, sum=0)
// └── right → f(1, sum=0)   // 3 is excluded
//
//
//Now we analyze only this call:
//
//2️⃣ At index 1 (value = 2)
//f(1, sum=0)
//
//
//It splits again:
//
//left  → f(2, sum=2)   // include 2
//right → f(2, sum=0)   // exclude 2
//
//
//👉 The two 1s you’re asking about both come from left → f(2, sum=2)
//
//3️⃣ Drill into f(2, sum=2)
//f(2, sum=2)   // nums[2] = 1
//
//
//Split:
//
//left  → f(3, sum=3)   // include first 1
//right → f(3, sum=2)   // exclude first 1
//
//4️⃣ First return 1
//f(3, sum=3)
//f(3, sum=3)   // nums[3] = 1
//
//
//Split:
//
//left  → f(4, sum=4) → return 0
//right → f(4, sum=3) → return 1  ✅
//
//
//So:
//
//f(3, sum=3) returns 1
//
//
//✔ subset: [2,1] (using nums[2])
//
//5️⃣ Second return 1
//
//Now go back to:
//
//f(3, sum=2)
//
//
//Split:
//
//left  → f(4, sum=3) → return 1  ✅
//right → f(4, sum=2) → return 0
//
//
//So:
//
//f(3, sum=2) returns 1
//
//
//✔ subset: [2,1] (using nums[3])
//
//6️⃣ Where the ADDITION happens
//
//Now recursion unwinds ⬆️
//
//At index 2:
//f(2, sum=2)
//left  = 1
//right = 1
//return left + right = 2
//
//
//🔥 THIS is where the two 1s add up
//
//7️⃣ Propagation upward
//
//Now at index 1:
//
//f(1, sum=0)
//left  = 2   // from f(2, sum=2)
//right = 0   // from f(2, sum=0)
//return 2
//
//
//So the right branch of index 0 contributes 2
//
//8️⃣ Final mental model (IMPORTANT)
//
//Each leaf node returns 1 if valid
//
//Parent nodes SUM all children returns
//
//right is not one return — it is left + right of its own subtree
//
//🔑 One-line answer to your question
//
//The two return 1s happen at different leaf calls, and they get added together when recursion returns back to index 2, producing 2, which is then passed upward as right.
//
//If you want next:
//
//I can draw this exact subtree
//
//Or rewrite this using DP count table
//
//Or show how to avoid counting duplicate-value subsets
//
//Just say 👍