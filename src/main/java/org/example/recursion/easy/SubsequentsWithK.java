package org.example.recursion.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubsequentsWithK {
    public static void main(String[] args) {
        int[] arr={10, 1, 2, 7, 6, 1, 5};
        SubsequentsWithK subsequentsWithK=new SubsequentsWithK();
        System.out.println(subsequentsWithK.checkSubsequenceSum(arr,8));
    }
    public ArrayList<ArrayList<Integer>> checkSubsequenceSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        dfs(arr,0,k,result,0,new ArrayList<>());
        return result;
    }

    public void dfs(int[] arr,int n,int k,ArrayList<ArrayList<Integer>> result,int sum,ArrayList<Integer> subarray){
       if(n==arr.length-1) {
           if (sum == k)
               result.add(new ArrayList<>(subarray));
           return;
       }
        sum=sum+arr[n];
        subarray.add(arr[n]);
        dfs(arr,n+1,k,result,sum,subarray);
        sum=sum-arr[n];
        subarray.remove(subarray.size()-1);
        dfs(arr,n+1,k,result,sum,subarray);
    }
}
