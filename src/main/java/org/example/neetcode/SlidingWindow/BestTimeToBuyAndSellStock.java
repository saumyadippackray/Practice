package org.example.neetcode.SlidingWindow;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(BestTimeToBuyAndSellStock.maxProfit(new int[]{2,1,2,1,0,1,2}));
    }
    public static int maxProfit(int[] prices) {
        int firstPointer=0;
        int secondPointer=1;
        int maxProfit=0;

        while (secondPointer<prices.length){
            if(prices[firstPointer]>prices[secondPointer]) firstPointer=secondPointer;
            else {maxProfit=Math.max(maxProfit,(prices[secondPointer]-prices[firstPointer]));
            secondPointer++;}
        }
        return maxProfit;
    }
}

//[10,1,5,6,7,1]
//We have to run two pointer if the second pointer is less than first then we will increase the first pointer and every time increase
//the second pointer
//->10 ->1 5 6 7 1
//10 ->1 ->5 6 7 1 --profit 4
//10 ->1 5 ->6 7 1 --profit 5
//10 ->1 5 6 ->7 1 --profit 6
//10 ->1 5 6 7 ->1 --profit 0
