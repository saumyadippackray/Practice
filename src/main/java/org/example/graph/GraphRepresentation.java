package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRepresentation {
    public static void main(String[] args) {
        int n = 10; // nodes
       // System.out.println(bfsOfGraph(n,representationWithArraylist(n)));
        System.out.println(dfsGraph(n,representationWithArraylist(n)));
    }

    public static ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){ //v=number of node
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[V+1];
        Queue<Integer> q=new LinkedList<>();

        q.add(1);
        vis[1]=true;

        while (!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);

            for(Integer it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }


    public static void dfs(boolean vis[], int node, List<Integer> dfsNode,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        dfsNode.add(node);

        for(Integer n:adj.get(node)){
            if(vis[n]==false){
                dfs(vis,n,dfsNode,adj);
            }
        }
    }

    public static List<Integer> dfsGraph(int n,ArrayList<ArrayList<Integer>> adj){
        boolean vis[]=new boolean[n+1];
        vis[1]=true;
        List<Integer> dfsNode=new ArrayList<>();
        dfs(vis,1,dfsNode,adj);
        return dfsNode;
    }


    public static ArrayList<ArrayList<Integer>> representationWithArraylist(int n) {


        int m = 15; // edges

    /*

             1 -------- 2 -------- 5
            / \        / \        / \
           /   \      /   \      /   \
          3     4 ---6-----7----8     9
           \         |     \          /
            \        |      \        /
             --------10------\------

    Edges:
    1--2
    1--3
    1--4
    2--4
    2--5
    2--6
    3--4
    3--10
    4--6
    5--7
    5--8
    6--7
    6--10
    7--8
    8--9
    */

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Create n+1 lists because we are using nodes 1 to n
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        // 1 -- 2
        adj.get(1).add(2);
        adj.get(2).add(1);

        // 1 -- 3
        adj.get(1).add(3);
        adj.get(3).add(1);

        // 1 -- 4
        adj.get(1).add(4);
        adj.get(4).add(1);

        // 2 -- 4
        adj.get(2).add(4);
        adj.get(4).add(2);

        // 2 -- 5
        adj.get(2).add(5);
        adj.get(5).add(2);

        // 2 -- 6
        adj.get(2).add(6);
        adj.get(6).add(2);

        // 3 -- 4
        adj.get(3).add(4);
        adj.get(4).add(3);

        // 3 -- 10
        adj.get(3).add(10);
        adj.get(10).add(3);

        // 4 -- 6
        adj.get(4).add(6);
        adj.get(6).add(4);

        // 5 -- 7
        adj.get(5).add(7);
        adj.get(7).add(5);

        // 5 -- 8
        adj.get(5).add(8);
        adj.get(8).add(5);

        // 6 -- 7
        adj.get(6).add(7);
        adj.get(7).add(6);

        // 6 -- 10
        adj.get(6).add(10);
        adj.get(10).add(6);

        // 7 -- 8
        adj.get(7).add(8);
        adj.get(8).add(7);

        // 8 -- 9
        adj.get(8).add(9);
        adj.get(9).add(8);

        // Print adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");

            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }

            System.out.println();
        }

        return adj;
    }
}
