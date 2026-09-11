package org.example.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RottingFruit {
    public static void main(String[] args) {
        int[][] grid = {{0,2,2}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int[][] neighbours={{-1,0},
                {0,-1},
                {1,0},
                {0,1}};
        int ROW=grid.length;
        int COL=grid[0].length;
        int count=0;
        int fresh=0;

        Queue<int[]> q=new LinkedList<>();

        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(grid[r][c]==1)
                    fresh++;
                if(grid[r][c]==2)
                    q.add(new int[]{r,c});
            }
        }

        while (!q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                int[] node=q.poll();
                for(int[] neighbour:neighbours) {
                    int neighbourRow = node[0] +neighbour[0];
                    int neighbourCol=node[1]+neighbour[1];

                    if(neighbourRow>=0 && neighbourCol>=0 && neighbourRow<ROW && neighbourCol<COL
                    && grid[neighbourRow][neighbourCol]==1){
                        q.add(new int[]{neighbourRow,neighbourCol});
                        grid[neighbourRow][neighbourCol]=2;
                        fresh--;
                    }
                }
            }
            if(!q.isEmpty()) {
                count++;
            }
        }
        if(fresh!=0)
            return -1;
        return count;
    }

}
