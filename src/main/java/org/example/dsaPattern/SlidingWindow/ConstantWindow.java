package org.example.dsaPattern.SlidingWindow;

public class ConstantWindow {
    public static void main(String[] args) {
        int unsortedArray[]={1,2,2,6,5,1,31,120};
        ConstantWindow constantWindow=new ConstantWindow();
        System.out.println(constantWindow.getMaxSum(unsortedArray,4));
    }

    public int getMaxSum(int[] arr,int k){
        int length=arr.length;
        int sum=0;
        int start=0;
        for(int i=0;i<k;i++)
            sum=sum+arr[i];
        int maxSum=sum;
        while(k<length-1){
            sum=sum-arr[start];
            start++;
            k++;
            sum=sum+arr[k];
            maxSum=Integer.max(maxSum,sum);
        }
        return maxSum;
    }
}
