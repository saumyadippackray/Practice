package org.example.stringProblems;

public class ReverseWord {
    public static String reverseWords(String s) {
        s.trim();
        String[] splitString=s.split("\\s+");
        String str="";
        for(int i=splitString.length-1;i>=0;i--){
            if(i!=0){
                str=str+splitString[i]+" ";
            }
            else{
                str=str+splitString;
            }
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(ReverseWord.reverseWords(" Suman is a ggod boy "));
    }
}
