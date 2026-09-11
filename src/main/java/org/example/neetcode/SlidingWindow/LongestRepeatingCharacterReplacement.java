package org.example.neetcode.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(LongestRepeatingCharacterReplacement.characterReplacement("ABABBA",2));
    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> charCount=new HashMap<>();
        int leftPoint=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            charCount.put(s.charAt(i),charCount.getOrDefault(s.charAt(i),0)+1);
            int highestValue= Collections.max(charCount.values());
            //int arraySize=i-leftPoint+1;
            while ((i-leftPoint+1)-highestValue>k){
                charCount.put(s.charAt(leftPoint),charCount.get(s.charAt(leftPoint))-1);
                leftPoint++;
            }
            result=Math.max(result,(i-leftPoint+1));
        }
        return result;
    }
}
//FP=first pointer SP=Second Pointer
//ABABBA k=2 --- start two pointers both from starting position we will increase the second pointer and add the character count in a hashmap and every time we
//will check the array size from first pointer to second pointer and what is the highest occurrence of any character and subtract from the array and check
//if that is less than the k if that value will be grater than k then we will increase the first pointer until the array size and highest occur char's subtraction
//is equal or less than tha k and when we will remove the first pointer we will also remove the char count for those particular position from the hashmap.

//ABABBA - Here FP=0 and SP=4 count of A=2 and B=3 so length of array=5 and length of highest occurred char is B=3 so 5-3=2 which is equal k we can replace but
//when the SP=5 then the A=3 and B=3 and length of array=6 and length of highest occurred char is B=3 so 6-3=3 which is greater tha k we can't replace so we have
//to shift the SP until the array-highest occurrence<=k. we will shift FP=1 and remove the char from the position which is B so now count of B=2 and count of A=3
//and the array size =5 so we can do 5-3=2 which is equal to k so we can replace.

