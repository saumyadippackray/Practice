package org.example.neetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(PermutationInString.checkInclusion("abc","lecabee"));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] firstStringChar=new int[26];
        int[] secondStringChar=new int[26];
        int match=0;
        int firstPointer=0;
        for (int i = 0; i < s1.length(); i++) {
            firstStringChar[s1.charAt(i)-'a']++;
            secondStringChar[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(firstStringChar[i]==secondStringChar[i]){
                match++;
            }
        }

        for(int i=s1.length();i<s2.length();i++){
            if(match==26)
                return true;

            int index=s2.charAt(i)-'a'; //retrieve the index for i position char
            secondStringChar[index]++; // increase the count by 1
            if(secondStringChar[index]==firstStringChar[index]) match++; //then we check after the new count add the count is match with the first array for that particuler position
            else if (secondStringChar[index]-1==firstStringChar[index]) { // Now we are checking is the previous match reduce because of new count update for the we will simpily decrease the count in 2nd array
                //that we have increased and check if it matches with the first array
                match--;
            }

            //Now we have to do the same thigh for the first char we have to check after remove the first char if the match changes
            index=s2.charAt(firstPointer)-'a';
            secondStringChar[index]--; //because of sliding window we are slid the window in the upp we have added one new char in the end now we are removing the char
            //from start
            if(secondStringChar[index]==firstStringChar[index]) match++; //here we check if the match reduced becuase of the char count reduction we just
                // increase the count by 1 that we have decreased and check if it was previously matched
            else if (secondStringChar[index]+1==firstStringChar[index]) {match--; }// we check after count updation the count matched with the first array;

            firstPointer++; //increase the first pointer
        }
        return match==26;
    }
}

 //abc        //ecabee
//1 1 1 0 0  //1 1 1 0 3
// save first string in a array and second string upto first string length in a array to for the upper case lec
// and then iterate both arrays and check how many matching and save the count in match variable
// Now we have to start two pointer one from 0 and one from s1.length and check. start the sliding window approch.
// now we will move the window and check if any match increase when we are shifting the second pointer and decrease when move the first char.
// basically we have to recalculate the match after pointer shifting

//Sure! Let's dry run the code using an example so you clearly understand how it works.
//
//        📌 Problem the code solves
//
//        The method checks whether any permutation of s1 exists as a substring in s2.
//
//        🧪 Example for Dry Run
//        s1 = "ab"
//        s2 = "eidbaooo"
//
//        Step 1: Initial Checks
//        Variable	Value
//        s1 length	2
//        s2 length	8
//
//        Since 2 ≤ 8, continue.
//
//        Step 2: Build Frequency Arrays for First Window
//
//        We use frequency arrays of size 26 (for each alphabet letter).
//
//        Loop runs for i = 0 → 1 (length of s1)
//
//        i	char in s1	firstStringChar	char in s2	secondStringChar
//        0	'a'	a=1	'e'	e=1
//        1	'b'	b=1	'i'	i=1
//
//        So,
//
//        firstStringChar:  {a:1, b:1}
//        secondStringChar: {e:1, i:1}
//
//        Step 3: Count Initial Matches
//
//        Compare both arrays index-wise.
//        Only letters where counts match increase match.
//
//        Here all 24 other characters match because both arrays have 0 for them.
//
//        So:
//
//        match = 24
//
//
//        (because only ‘a’ and ‘b’ mismatch between arrays)
//
//        Step 4: Sliding Window
//
//        Now we start sliding over s2 beginning at index = 2
//
//        Window movement details
//        Iteration 1
//
//        Window characters in s2: "ei" → "id"
//        Current index i = 2, firstPointer = 0
//
//        Add new character 'd'
//
//        secondStringChar['d']++ → now 'd' becomes 1
//
//        It was previously equal? No → no match++
//
//        Check if it just broke match: first['d']=0, now second['d']=1 -> mismatch → match--
//
//        So:
//
//        match = 24 - 1 = 23
//
//        Remove outgoing character 'e'
//
//        secondStringChar['e']-- → e becomes 0
//
//        Now equals firstStringChar('e'=0) → match++
//
//        So:
//
//        match = 23 + 1 = 24
//
//        Iteration 2
//
//        Window: "id" → "db"
//        Current index i = 3, firstPointer = 1
//
//        Add new char 'b'
//
//        second['b'] from 0 → 1
//
//        Equals first['b']=1 -> match++
//
//        match = 24 + 1 = 25
//
//
//        Remove outgoing char 'i'
//
//        second['i'] from 1 → 0
//
//        first['i']=0 → match++
//
//        match = 25 + 1 = 26
//
//
//        🎉 When match == 26, that means all frequency counts match, so permutation found → return true.
//
//        So substring "ba" exists in "eidbaooo" → valid permutation.
//
//        🚀 Final Result
//        return true;
//
//        🔎 Key Logic Summary
//
//        Compare frequency counts of window in s2 vs s1
//
//        Slide window one char at a time
//
//        Update matches intelligently using increments/decrements
//
//        If ever match == 26, permutation is found
//
//        If you'd like, I can also provide a table-based dry run showing all array values step-by-step.
//        Would you like that? 😊