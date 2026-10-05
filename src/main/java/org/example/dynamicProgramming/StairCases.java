package org.example.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StairCases {
    public static void main(String[] args) {
        StairCases stairCases=new StairCases();
        int n=3;
        int[] cache =new int[3];
        Arrays.fill(cache,-1);
        System.out.println(stairCases.dfs(0,n,cache));
    }

    public int dfs(int i,int n,int[] cache){
        if(i==n) {
            return 1;
        }
        if(i>n)
            return 0;
        if(cache[i]!=-1)
            return cache[i];
        return cache[i]=dfs(i+1,n,cache)+dfs(i+2,n,cache);
    }
}
