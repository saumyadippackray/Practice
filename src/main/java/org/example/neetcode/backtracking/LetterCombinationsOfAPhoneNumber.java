package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("345"));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        getCombination(0,"",digits,result);
        return result;
    }

    public static void getCombination(int i,String charString,String digits,List<String> result){
        if(charString.length()==digits.length()){
            result.add(charString);
            return;
        }
        String charAtDigit=digitToChar[digits.charAt(i)-'0'];
        for(char c:charAtDigit.toCharArray()){
            getCombination(i+1,charString+c,digits,result);
        }

    }
}
