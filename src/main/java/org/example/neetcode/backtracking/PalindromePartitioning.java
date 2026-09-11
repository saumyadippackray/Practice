package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    public static List<List<String>> partition(String s) {
        List<String> part=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();

        addPalindrome(0,s,part,result);
        return result;
    }

    public static void addPalindrome(int i,String s,List<String> part,List<List<String>> result){
        if(i>=s.length())
        {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j=i;j<s.length();j++){
            if(isPalindrome(i,j,s)){
                part.add(s.substring(i,j+1));
                addPalindrome(j+1,s,part,result);
                part.remove(part.size()-1);
            }
        }
    }

    public static boolean isPalindrome(int i,int j,String s){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}
