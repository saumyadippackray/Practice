package org.example.neetcode.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(LongestSubStringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int longestSubstringLength=0;
        int start=0;
        HashSet<Character> charSet=new HashSet<>();
        for(int i=0;i<s.length();i++){
            while (charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(start));
                start++;
            }
            charSet.add(s.charAt(i));
            longestSubstringLength=Math.max(longestSubstringLength,i-start+1);
        }
        return longestSubstringLength;
    }
    public static int lengthOfLongestSubstringNotWorking(String s) {
        int longestSubstringLength=0;
        int start=0;
        int end=1;
        HashSet<Character> charSet=new HashSet<>();
        while (s.length()>end){
            if(start==0) charSet.add(s.charAt(start));
            if(charSet.contains(s.charAt(end))){
                longestSubstringLength=Math.max(longestSubstringLength,end-start);
                start++;
            }
            else {
                charSet.add(s.charAt(end));
            }
            end++;
        }
        return longestSubstringLength;
    }
}

//zxyzaxyz
//we have to run two pointer one from 0 and one from 1 and add in a hashset if any element is there we have
//to increase the first pointer and remove the element from start until the duplicate has removed

//pwwkew

//pw -- hashset- p,w
//pww-- in this position we will delete from the until the duplicate element is there and increase the first pointer and add the new element as 'w' is the dupliacte then upto 'w' will be
//deleted the new hashset will be {} and then new element will add the new hash set is {w}
