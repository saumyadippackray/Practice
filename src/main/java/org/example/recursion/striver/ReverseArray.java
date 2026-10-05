package org.example.recursion.striver;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        ReverseArray reverseArray=new ReverseArray();
        reverseArray.dfs(arr,0);
        System.out.println(Arrays.toString(arr));
    }
    void dfs(int[] arr,int start,int end){
        if(end<=start)
            return;
        int i=arr[start];
        arr[start]=arr[end];
        arr[end]=i;
        dfs(arr,start+1,end-1);

    }

    void dfs(int[] arr,int pointer){
        if(pointer>= (arr.length)/2)
            return;
        int pointer2=arr.length-pointer-1;
        int i=arr[pointer];
        arr[pointer]=arr[pointer2];
        arr[pointer2]=i;
        dfs(arr,pointer+1);

    }
}
