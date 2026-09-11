package org.example.recursion.easy;

public class CheckPalindrome  {
    public static void main(String[] args) {
        CheckPalindrome checkPalindrome=new CheckPalindrome();
        System.out.println(checkPalindrome.check("aabbbbaac",0,"aabbbbaac".length()-1));
    }

    public boolean check(String str,int firstIndex,int lastIndex){
        if(firstIndex>=lastIndex)
            return true;

        if(str.charAt(firstIndex)!=str.charAt(lastIndex))
            return false;
        return check(str,firstIndex+1,lastIndex-1);
    }
}

//a b a
//a b a