package org.example.graph;

import java.util.*;

public class ConnectedComponent {
    public static void main(String[] args) {
        ConnectedComponent connectedComponent=new ConnectedComponent();
        int n=5;
        int[][] edges={{0,1},{1,2},{3,4}};
        System.out.println(connectedComponent.countComponents(n,edges));
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

       for(int[] edge:edges){
           adj.get(edge[0]).add(edge[1]);
           adj.get(edge[1]).add(edge[0]);
       }

       HashSet<Integer> visited=new HashSet<>();
       int count=0;
       for(int i=0;i<n;i++){
           if(!visited.contains(i)){
               bfs(i,adj,visited);
               count++;
           }
       }

       return count;
    }

    public void dfs(int node, List<List<Integer>> adj,HashSet<Integer> visited){
        visited.add(node);
        for(Integer n:adj.get(node)){
            if(!visited.contains(n)) {
                dfs(n, adj, visited);
            }
        }

    }

    public void bfs(int node, List<List<Integer>> adj,HashSet<Integer> visited){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        visited.add(node);

        while (!q.isEmpty()){
            int curr=q.poll();
            for(int i:adj.get(curr)){
                if(!visited.contains(i)) {
                    q.add(i);
                    visited.add(i);
                }
            }
        }
    }
}
