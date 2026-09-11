package org.example.neetcode.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(LongestConsecutiveSequence.longestConsecutive(new int[]{100,1,200,4,3,2}));
    }
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        int highestSequence=0;
        for(int num:nums){
            numSet.add(num);
        }

        for(int num:numSet){
            int repeat=0;
            int newNumber=0;
            if(!numSet.contains(num-1)){
                newNumber=num;
                while (numSet.contains(newNumber)){
                    repeat++;
                    newNumber=newNumber+1;
                }
            }
            if(repeat>highestSequence)
                highestSequence=repeat;
        }
        return highestSequence;
    }
}


// 100,1,200,2,3,4
// Have to check first which number has not the left number after that we have to count the sequence of those numbers