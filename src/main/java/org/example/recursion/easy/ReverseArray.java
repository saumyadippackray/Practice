package org.example.recursion.easy;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6};
        reverse(arr,0,arr.length-1);
        for (int i:arr){
            System.out.println(i);
        }
    }

    public static void reverse(int[] arr,int left,int right){
        if(left>=right)
            return;
        swap(arr,left,right);
        reverse(arr,left+1,right-1);
    }

    public static void swap(int[] arr,int left,int right){
        int a=arr[left];
        arr[left]=arr[right];
        arr[right]=a;
    }
}
