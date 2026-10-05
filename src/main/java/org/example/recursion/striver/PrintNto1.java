package org.example.recursion.striver;

public class PrintNto1 {
    public static void main(String[] args) {
        PrintNto1 printNto1=new PrintNto1();
        printNto1.dfs(5,1);
    }

    public void dfs(int n,int k){
        if(k>n)
            return;

        dfs(n,k+1);
        System.out.println(k);
    }
}
