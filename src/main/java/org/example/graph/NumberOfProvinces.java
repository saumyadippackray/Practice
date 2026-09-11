package org.example.graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        findCircleNum(isConnected);
    }

    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for (int i=0;i<=isConnected.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        System.out.println(adj);
        int n=isConnected.length+1;
        int[] visitedArray=new int[n+1];
        int count=0;

        for (int i=1;i<n;i++){
            if(visitedArray[i]==0){
                count++;
                dfs(adj,i,visitedArray);
            }
        }
        System.out.println(count);
        return 0;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj,int node,int[] visitedArray){
        visitedArray[node]=1;
        for (Integer i:adj.get(node)){
            if(visitedArray[i]==0) {
                dfs(adj, i, visitedArray);
            }
        }
    }
}
