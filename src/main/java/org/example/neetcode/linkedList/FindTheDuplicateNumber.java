package org.example.neetcode.linkedList;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        findDuplicate(new int[]{1,3,4,2,2});
    }
    public static int findDuplicate(int[] nums) {
        int slow1=0,fast=0;

        while (true){
            slow1=nums[slow1];
            fast=nums[nums[fast]];
            if(slow1==fast)
                break;
        }
        System.out.println(slow1); //Here we have found the first intersect point between fast pointer and slow pointer --- Floyd's algo
        int slow2=0;
        while (true){
            slow1=nums[slow1];
            slow2=nums[slow2];
            if(slow1==slow2)
                break;
        }
        System.out.println(slow1);//Here we have found the second intersect point between slow pointer 1 and slow pointer 2--- Floyd's algo
        return slow1;
    }
}
