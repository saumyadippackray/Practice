package org.example.neetcode.twopointer;

public class TwoIntegerSum2 {

    public static void main(String[] args) {
        TwoIntegerSum2.twoSumOptimized(new int[]{1,2,3,4},4);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int firstPointer=0;
        int secondPointer=1;
        boolean flag=true;
        int[] result=new int[2];
        while (flag){
            if(numbers[firstPointer]+numbers[secondPointer]==target){
                result[0]=numbers[firstPointer];
                result[1]=numbers[secondPointer];
                flag=false;
            }
            if(secondPointer==numbers.length-1){
                firstPointer=firstPointer+1;
                secondPointer=firstPointer+1;
            }
            else {
                secondPointer++;
            }
        }
        return result;
    }

    public static int[] twoSumOptimized(int[] numbers, int target) {
        int firstPointer=0;
        int secondPointer=numbers.length-1;
        int[] result=new int[2];
        while (secondPointer>firstPointer){
            if(numbers[firstPointer]+numbers[secondPointer]>target){
                secondPointer--;
            }
            else if(numbers[firstPointer]+numbers[secondPointer]<target){
                firstPointer++;
            } else if (numbers[firstPointer]+numbers[secondPointer]==target) {
                result[0]=firstPointer+1;
                result[1]=secondPointer+1;
                return result;
            }

        }
        return result;
    }
}
//1 3 4 5 7 11 target=9
//We will start two pointer one from start one from end. When the combined value will be greater than the target then we will move the second pointer one index left
//and when the combined value will be less than the target then we will move the first pointer one index right
//->1 3 4 5 7 ->11 the combined value is 12 which is greater than 9 so I will move the second pointer
//->1 3 4 5 ->7 11  the combined value is 8 which is less than 9 so I will move the first pointer
//1 ->3 4 5 ->7 11  the combined value is 10 which is greater than 9 so I will move the second pointer
//1 ->3 4 ->5 7 11 the combined value is 8 which is less than 9 so I will move the first pointer
//1 3 ->4 ->5 7 11 Now the combined value is 9 and we solve this