package org.example.leetCode;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(ValidAnagram.isAnagram("suman","mansu"));
    }
    public static boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())
            return false;


        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

       for(int i=0;i<s.length();i++){
           countT.put(s.charAt(i),countT.getOrDefault(s.charAt(i),0)+1);
           countS.put(s.charAt(i),countS.getOrDefault(s.charAt(i),0)+1);
       }
       return countT.equals(countS);
    }
}
