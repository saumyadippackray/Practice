package org.example.dynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StairCases {
    public static void main(String[] args) {
        StairCases stairCases=new StairCases();
        int n=0;
        int[] cache =new int[3];
        Arrays.fill(cache,-1);
        System.out.println(stairCases.dfs(0,n,cache));
    }
    public int dfs(int n,int stair,int[] cache){
        if (n >= stair) return stair == n ? 1 : 0;
        if(cache[n]!=-1)
            return cache[n];

        return  cache[n]=dfs(n+1,stair,cache)+dfs(n+2,stair,cache);
    }
}
