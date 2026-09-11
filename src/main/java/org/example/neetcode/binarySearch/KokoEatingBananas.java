package org.example.neetcode.binarySearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(KokoEatingBananas.minEatingSpeed(new int[]{25,10,23,4},4));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end= Arrays.stream(piles).max().getAsInt();
        int result=end;

        while (start<=end){
            int mid=start+(end-start)/2;
            int totalTimeTaken=0;
            for(int pile:piles){
                System.out.println("Pile=="+pile+"mid=="+mid+"Math round"+Math.round(pile/mid));
                totalTimeTaken += Math.ceil((double) pile / mid);
            }
            if(totalTimeTaken<=h){
                if(mid<result)
                    result=mid;
            }
            if(totalTimeTaken<=h){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return result;
    }
}
//piles = [1,4,3,2,7], h = 9
//We have to take the range from 1 to max element in array
//1,2,3,4,5,6,7 mid= 4 total time take- 1+1+1+1+2=6 which is less than 9 if less than 9 then we will go for the left to mid-1
// 1 2 3 mid=2 total time take= 1+2+2+1+4=10 now right=mid+1
// 3 mid=3+3/2=3 total time taken 1+2+1+1+3=8