package org.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges={{1,2},{1,3},{3,4},{2,4}};
        RedundantConnection redundantConnection=new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){

            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            HashSet<Integer> visited=new HashSet<>();

            if(dfs(edge[0],-1,adj,visited))
                return edge;

        }
        return new int[]{};
    }

    public boolean dfs(int node,int parent,List<List<Integer>> adj,HashSet<Integer> visited){
        if(visited.contains(node)){
            return true;
        }
        visited.add(node);
        for(Integer a:adj.get(node)){
            if(a==parent)
                continue;
            if(dfs(a,node,adj,visited))
                return true;
        }
        return false;
    }
}
