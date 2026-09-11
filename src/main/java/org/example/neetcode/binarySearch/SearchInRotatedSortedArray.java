package org.example.neetcode.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(SearchInRotatedSortedArray.search(new int[]{5,1,3},5));
    }
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;

            if(target==nums[mid])
                return mid;

            if(nums[left]<=nums[mid]){
                //[6,1,2,3,4,5]
                if(target>nums[mid])
                    left=mid+1;  // we are entering the sorted portion so if the target is greater than mid then
                //the targeted element must be on the left 2,3,4,5,6,1 if we search for the 6. Here 4 is the mid
                else if (target<nums[left])
                    left=mid+1; // example 2,3,4,5,6,1 search for the 1
                else right=mid-1;
            }
            else{
                if(target>nums[right])
                    right=mid-1;
                else if (target<nums[mid])
                    right=mid-1;
                else left=mid+1;
            }
        }
        return -1;
    }
}

//nums = [3,4,5,6,1,2], target = 2
//[6,1,2,3,4,5]
//[3,4,5,6,1,2] -- mid=5 check if the left portion is sort and check the target is in between is not we will procced with other part.
//[6,1,2]
//1,2
