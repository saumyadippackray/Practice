package org.example.neetcode.arraysandhashing;

public class ProductOfArrayExpectSelf {

    public static void main(String[] args) {
        ProductOfArrayExpectSelf.productExceptSelf(new int[]{1,2,3,4});
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] postFix=new int[nums.length];
        int[] result=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(i==0){
                prefix[i]=nums[i];
            }
            else {
                prefix[i]=nums[i]*prefix[i-1];
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                postFix[i]=nums[i];
            }
            else {
                postFix[i]=nums[i]*postFix[i+1];
            }
        }
        for(int i=0;i<result.length;i++){
            if(i==0){
                result[i]=1*postFix[i+1];
            }
            else if(i==result.length-1){
                result[i]=1*prefix[i-1];
            }
            else{
                result[i]=prefix[i-1]*postFix[i+1];
            }

        }
        System.out.println(result);
        System.out.println(postFix);
        return nums;
    }
}

//1 2 3 4
//prfix 1 2 6 24
//postfix 24 24 12 4
//result= 1*24  1*12 2*4 6*1
// basically we have to do the prefix and post fix multiply for 2 it the prefix is 1 and the postfix os 12 so the result will be 1*12=12