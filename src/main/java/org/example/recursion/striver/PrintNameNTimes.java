package org.example.recursion.striver;

public class PrintNameNTimes {
    public static void main(String[] args) {
        PrintNameNTimes printNameNTimes=new PrintNameNTimes();
        printNameNTimes.dfs(5,0);
    }

    public void dfs(int n,int k){
        if(k==n)
            return;
        System.out.println("Suman");
        dfs(n,k+1);
    }
}

//TC O(N)
//SS O(N)
