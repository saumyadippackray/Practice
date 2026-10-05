package org.example.recursion.striver;

import java.util.ArrayList;

public class FirstSubsquentWithSum {
    public static void main(String[] args) {
        FirstSubsquentWithSum firstSubsquentWithSum=new FirstSubsquentWithSum();
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        firstSubsquentWithSum.subsequentArrayDfsWithTargetSum(new int[]{1,2,1},0,2,new ArrayList<>(),result,0);
        System.out.println(result);
    }
    public void SubsequentArrayDfs(int[] arr, int sum,int targetSum, ArrayList<Integer> subArray,ArrayList<ArrayList<Integer>> result,int index){
        if(index==arr.length){
              result.add(new ArrayList<>(subArray));
              return ;
        }

        subArray.add(arr[index]);
        SubsequentArrayDfs(arr,sum,targetSum,subArray,result,index+1);
        subArray.remove(subArray.size()-1);
        SubsequentArrayDfs(arr,sum,targetSum,subArray,result,index+1);

    }

    public void subsequentArrayDfsWithTargetSum(int[] arr, int sum,int targetSum, ArrayList<Integer> subArray,ArrayList<ArrayList<Integer>> result,int index){
        if(index==arr.length){
            if(sum==targetSum)
                result.add(new ArrayList<>(subArray));
            return ;
        }

        sum=sum+arr[index];
        subArray.add(arr[index]);
        subsequentArrayDfsWithTargetSum(arr,sum,targetSum,subArray,result,index+1);
        subArray.remove(subArray.size()-1);
        sum=sum-arr[index];
        subsequentArrayDfsWithTargetSum(arr,sum,targetSum,subArray,result,index+1);

    }

    public boolean dfs(int[] arr, int sum,int targetSum, ArrayList<Integer> subArray,ArrayList<ArrayList<Integer>> result,int index){
        if(index==arr.length){
            if(sum==targetSum) {
                result.add(new ArrayList<>(subArray));
                return true;
            }
            else
                return false;
        }

        subArray.add(arr[index]);
        sum=sum+arr[index];
        if(dfs(arr,sum,targetSum,subArray,result,index+1))
            return true;
        subArray.remove(subArray.size()-1);
        sum=sum-arr[index];
        if(dfs(arr,sum,targetSum,subArray,result,index+1))
            return true;
        return false;
    }

    public int dfsNumberOfSubsequentWithTargetSum(int[] arr, int sum,int targetSum, int index){
        if(index==arr.length){
            if(sum==targetSum) {
               return 1;
            }
            else
                return 0;
        }

        sum=sum+arr[index];
        int l=dfsNumberOfSubsequentWithTargetSum(arr,sum,targetSum,index+1);
        sum=sum-arr[index];
        int r=dfsNumberOfSubsequentWithTargetSum(arr,sum,targetSum,index+1);
        return l+r;

    }
}
