package org.example.graph;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        int n = 4;
//        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int[][] edges = {{0,1},{2,3}};
        GraphValidTree graphValidTree=new GraphValidTree();
        System.out.println(graphValidTree.validTree(n,edges));
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        HashSet<Integer> isVisited=new HashSet<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.out.println(adj);

        if(!dfs(0,-1,adj,isVisited))
            return false;

        return isVisited.size()==n;
    }

    public boolean dfs(int n,int parent, List<List<Integer>> adj, HashSet<Integer> isVisited){
        if(isVisited.contains(n))
            return false;

        isVisited.add(n);
        for(Integer integer:adj.get(n)){
            if(integer==parent)
                continue;
            if(!dfs(integer,n,adj,isVisited))
                return false;
        }
        return true;
    }
}
