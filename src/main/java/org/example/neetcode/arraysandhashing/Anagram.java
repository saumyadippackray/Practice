package org.example.neetcode.arraysandhashing;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        Anagram anagram=new Anagram();
        System.out.println(anagram.isAnagram("suman","namuss"));
    }

    public boolean isAnagram(String s, String t) {
        char[] sortedArr1=s.toCharArray();
        char[] sortedArr2=t.toCharArray();
        Arrays.sort(sortedArr2);
        Arrays.sort(sortedArr1);
        return Arrays.equals(sortedArr1,sortedArr2);
    }
}
