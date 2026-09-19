package org.example.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinPath {
    public static void main(String[] args) {
        MinPath minPath=new MinPath();
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPath.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        Queue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(k->k[0]));
        int[][] neighbors=new int[][] {{1,0},{0,1}};

        int startRow=0;
        int startCol=0;
        int endRow=grid.length-1;
        int endCol=grid[0].length-1;

        q.add(new int[]{grid[0][0],startRow,startCol});

        int[][] dist = new int[grid.length][grid[0].length]; // improvement we will not recalculate again and again
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        while (!q.isEmpty()){
            int[] node=q.poll();
            if(node[1]==endRow && node[2]==endCol)
                return node[0];
            if(node[0]>dist[node[1]][node[2]])
                continue;
            for(int[] neighbor:neighbors){
                int neighborRow=node[1]+neighbor[0];
                int neighborCol=node[2]+neighbor[1];
                if(neighborRow>=0 && neighborCol>=0 && neighborCol<grid[0].length && neighborRow<grid.length){
                    int newCost = node[0]+grid[neighborRow][neighborCol];
                    if(newCost<dist[neighborRow][neighborCol]){
                        dist[neighborRow][neighborCol]=node[0]+grid[neighborRow][neighborCol];
                        q.add(new int[]{node[0]+grid[neighborRow][neighborCol],neighborRow,neighborCol});
                    }
                }
            }
        }
        return dist[grid.length-1][grid[0].length-1];
    }
}
