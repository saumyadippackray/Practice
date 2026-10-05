package org.example.recursion.striver;

public class StringPallindrom {
    public static void main(String[] args) {
        StringPallindrom stringPallindrom=new StringPallindrom();
        System.out.println(stringPallindrom.dfs("madaam",0));
    }
    public boolean dfs(String str,int i){
        int lastPoint=str.length()-i-1;
        if(i>=lastPoint){
            return true;
        }
        if(str.charAt(i)!=str.charAt(lastPoint))
            return false;
        return dfs(str,i+1);
    }
}
