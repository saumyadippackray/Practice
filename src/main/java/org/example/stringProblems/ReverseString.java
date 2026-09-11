package org.example.stringProblems;

public class ReverseString {
    public static String reverseString(String str){
        char[] chars=str.toCharArray();
        String newStrin="";
        for (int i=chars.length-1;i>=0;i--){
            newStrin=newStrin+chars[i];
        }
        return newStrin;
    }

    public static void main(String[] args) {
        System.out.println(ReverseString.reverseString("suman tuki"));
    }
}
