package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        subsets(new int[]{1,2,1});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        getSubsets(0,result,subset,nums);
        System.out.println(result);
        return result;
    }

    public static void getSubsets(int index,List<List<Integer>> result,List<Integer> subset,int[] nums){
      if(index>=nums.length){
          result.add(new ArrayList<>(subset));
          return;
      }

      subset.add(nums[index]);
      getSubsets(index+1,result,subset,nums);
      subset.remove(subset.size()-1);
      getSubsets(index+1,result,subset,nums);
    }
}
//🧠 Key Observations
//Height of tree = n = 3
//Total subsets = 2³ = 8
//Each element has 2 choices: include / exclude
//Subset is added only at index == nums.length
//🔁 Backtracking Visualization
//Example path:
//[] → [3] → [3,1] → [3,1,2]
//             ↑ backtrack (remove 2)
//        ↑ backtrack (remove 1)
//✅ Time & Space
//Time: O(2ⁿ)
//Space: O(n) recursion stack
//The logic is correct, but there is one critical mistake 👇
//You are adding the same subset object reference to result every time.
//
//❌ What’s wrong?
//result.add(subset);
//
//
//subset is mutable and reused during recursion.
//So all entries in result point to the same list, which finally becomes empty or incorrect.
//
//✅ Correct Fix
//
//You must add a copy of subset:
//
//result.add(new ArrayList<>(subset));
//                                  index=0, subset=[]
//                                 /                     \
//                        include 3                       exclude 3
//                       subset=[3]                       subset=[]
//                      index=1                            index=1
//                     /        \                         /        \
//           include 1          exclude 1         include 1         exclude 1
//          subset=[3,1]        subset=[3]        subset=[1]        subset=[]
//         index=2              index=2           index=2           index=2
//        /      \              /      \          /      \          /      \
//   +2           -2        +2           -2    +2           -2    +2           -2
// [3,1,2]     [3,1]       [3,2]        [3]   [1,2]         [1]   [2]           []
// index=3     index=3   index=3      index=3 index=3    index=3 index=3     index=3
//  (add)       (add)     (add)         (add)   (add)      (add)   (add)       (add)