package org.example.graph.advancegraph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SwimInRisingWater {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {0,1,2,10},
                {9,14,4,13},
                {12,3,8,15},
                {11,5,7,6}
        };
        SwimInRisingWater swimInRisingWater=new SwimInRisingWater();
        System.out.println(swimInRisingWater.swimInWater(grid));
    }
    public int swimInWater(int[][] grid) {
        int rowN=grid.length;
        int columnN=grid[0].length;
        int[][] nei=new int[][]{
                {0,-1},
                {0,1},
                {-1,0},
                {1,0}
        };

        Queue<int[]> q=new PriorityQueue<>(Comparator.comparingInt(k->k[0]));
        boolean[][] visited=new boolean[rowN][columnN];
        q.add(new int[]{grid[0][0],0,0});
        while (!q.isEmpty()){
            int[] node=q.poll();
            Integer waterLevel=node[0];
            int row=node[1];
            int column=node[2];
            if(row==rowN-1 && column==columnN-1)
                return waterLevel;
            for(int[] n:nei){
                int neiRow=row+n[0];
                int neiCol=column+n[1];

                if(neiRow>=0 && neiCol>=0 && neiCol<columnN && neiRow<rowN && !visited[neiRow][neiCol]){
                    q.offer(new int[]{Math.max(grid[neiRow][neiCol],waterLevel),neiRow,neiCol});
                    visited[neiRow][neiCol]=true;
                }
            }
        }
        return 0;
    }
}
