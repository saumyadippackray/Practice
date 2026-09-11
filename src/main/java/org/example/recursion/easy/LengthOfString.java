package org.example.recursion.easy;

public class LengthOfString {
    public static void main(String[] args) {
        LengthOfString lengthOfString=new LengthOfString();
        System.out.println(lengthOfString.length("SUman"));
    }

    public Integer length(String str){
        if(str.equals(""))
            return 0;
        else
            return length(str.substring(1))+1;
    }
}
