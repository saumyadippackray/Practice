package org.example.recursion.striver;

public class Print1toN {
    public static void main(String[] args) {
        Print1toN print1toN=new Print1toN();
        print1toN.dfs(5,1);
    }

    public void dfs(int n,int k){
        if(k>n)
            return;
        System.out.println(k);
        dfs(n,k+1);
    }
}
