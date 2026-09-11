package org.example.neetcode.binarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(FindMinimumInRotatedSortedArray.findMin(new int[]{3,4,5,6,1,2}));
    }
    public static int findMin(int[] nums) {
//        int start=0;
//        int end=nums.length-1;
//        while (start<end){
//            int mid=start+(end-start)/2;
//            if(nums[mid]<nums[end])
//                end=mid;
//            else
//                start=mid+1;
//        }
//        return nums[end];
        return findMinRecursion(nums,0,nums.length-1);
    }

    public static int findMinRecursion(int[] nums,int start,int end){
        if(start==end)
            return nums[start];
        int mid=start+(end-start)/2;
        if(nums[mid]<nums[end])
            return findMinRecursion(nums,start,mid);
        else
            return findMinRecursion(nums,mid+1,end);
    }

}
//3,4,5,6,1,2-- mid if the starting
//6 1 2
//6 1
//1
//There will be two conditions where l and mid will be in left sorted segment or mid and r will be in right sorted segement.
// If l and mid in sorted segement, then nums[l] < nums[mid] and the minimum element will be in the right part.
// If mid and r in sorted segment, then nums[mid] < nums[r] and the minimum element will be in the left part.
// After the binary search we end up finding the minimum element.