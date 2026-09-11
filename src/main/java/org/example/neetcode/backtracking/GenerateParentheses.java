package org.example.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        getGeneratedParenthesis(n,0, 0, res, stack);
        return res;
    }

    public static void getGeneratedParenthesis(int n,int openParenthesisCount,int closeParenthesisCount,List<String> result,StringBuilder stack){
        if(openParenthesisCount==n && closeParenthesisCount ==n){
            result.add(stack.toString());
            return;
        }

//        if(closeParenthesisCount>openParenthesisCount)
//            return;

        if(openParenthesisCount<n){
            stack.append('(');
            getGeneratedParenthesis(n,openParenthesisCount+1,closeParenthesisCount,result,stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if(openParenthesisCount>closeParenthesisCount){
            stack.append(')');
            getGeneratedParenthesis(n,openParenthesisCount,closeParenthesisCount+1,result,stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
 //--- why   if(openParenthesisCount<n)? Why not n/2?