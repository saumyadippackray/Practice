package org.example.recursion.easy;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString=new ReverseString();
        System.out.println(reverseString.reverse("Suman Tuki "));
    }

    public String reverse(String str){
        if(str.length()==0)
            return "";
        else
            return reverse(str.substring(1))+str.charAt(0);
        //System.out.println(str.substring(1));
    }
}
