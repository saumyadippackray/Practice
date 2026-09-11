package org.example.neetcode.twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(ValidPalindrome.checkPalindrome("Was it a car or a cat I saw?"));
    }
    public static boolean checkPalindrome(String s){
        int firstPointer=0;
        int secondPointer=s.length()-1;
        while(firstPointer<secondPointer){
            while (firstPointer<secondPointer && !alphaNum(s.charAt(firstPointer))) {
                firstPointer++;
            }
            while (firstPointer<secondPointer && !alphaNum(s.charAt(secondPointer))) {
                secondPointer--;
            }
            if(s.toLowerCase().charAt(firstPointer)!=s.toLowerCase().charAt(secondPointer))
                return false;
            firstPointer++;
            secondPointer--;
        }
        return true;
    }

    public static boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
