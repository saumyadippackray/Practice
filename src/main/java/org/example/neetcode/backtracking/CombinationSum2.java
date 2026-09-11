package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        combinationSum2(new int[]{9,2,2,4,6,1,5},8);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> combination=new ArrayList<>();
        Arrays.sort(candidates);
        getCombinationSum2(0,target,result,combination,candidates);
        System.out.println(result);
        return result;
    }

    public static void getCombinationSum2(int index,int target,List<List<Integer>> result,List<Integer> combination,int[] candidates){
      if(target==0) {
          result.add(new ArrayList<>(combination));
          return;
      }


      for(int i=index;i<candidates.length;i++){
          if(i>index && candidates[i]==candidates[i-1])
              continue;
          if(candidates[i]>target)
              break;

          combination.add(candidates[i]);
          getCombinationSum2(i+1,target-candidates[i],result,combination,candidates);
          combination.remove(combination.size()-1);
      }
    }
}
