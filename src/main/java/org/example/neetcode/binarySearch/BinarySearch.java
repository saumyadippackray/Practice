package org.example.neetcode.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(BinarySearch.binarySearch(new int[]{3,4,6,7,9,12,14,16},6,0,7));
    }

    public static int binarySearch(int[] nums,int target,int start,int end){
        if(start>end)
            return -1;

        int mid= start + (end - start) / 2;
        if(nums[mid]==target)
            return mid;
        else if (nums[mid]<target) {

            return binarySearch(nums,target,mid+1,end);
        }
        else {
            return binarySearch(nums,target,start,mid-1);
        }
    }
}

//[3,4,6,7,9,12,14,16]
//6