package org.example.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {0, 1, 1, 0, 1},
                        {0, 1, 0, 0, 1}
        };
        System.out.println(maxAreaOfIslandImprove(grid));
    }

    public static int maxAreaOfIslandImprove(int[][] grid) {// instade of extra visited here we are using same grid
        //int[][] visited=new int[grid.length][grid[0].length];
        int[][] dir={
                {-1,0},//up
                {1,0},//down
                {0,1},//right
                {0,-1}//left
        };
        Queue<int[]> q=new LinkedList<>();
        int area=0;
        int maxArea=0;

        for(int row=0;row<grid.length;row++){
            for (int col=0;col<grid[0].length;col++){
                if(grid[row][col]==1){
                    area=1;
                    grid[row][col]=0;
                    q.add(new int[]{row,col});

                    while (!q.isEmpty()){
                        int[] node=q.poll();

                        for(int i=0;i<dir.length;i++){
                            int neighborRow=node[0]+dir[i][0];
                            int neighborColumn=node[1]+dir[i][1];

                            if(neighborRow>=0 && neighborColumn>=0 && neighborRow<grid.length
                                    && neighborColumn<grid[0].length && grid[neighborRow][neighborColumn]==1){
                                q.add(new int[]{neighborRow,neighborColumn});
                                grid[neighborRow][neighborColumn]=0;
                                area++;
                            }
                        }
                    }
                    if(area>maxArea){
                        maxArea=area;
                    }
                }
            }
        }
        return maxArea;
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int[][] visited=new int[grid.length][grid[0].length];
        int[][] dir={
                {-1,0},//up
                {1,0},//down
                {0,1},//right
                {0,-1}//left
        };
        Queue<int[]> q=new LinkedList<>();
        int area=0;
        int maxArea=0;

        for(int row=0;row<grid.length;row++){
            for (int col=0;col<grid[0].length;col++){
               if(visited[row][col]!=1 && grid[row][col]==1){
                   area=1;
                   visited[row][col]=1;
                   q.add(new int[]{row,col});

                   while (!q.isEmpty()){
                       int[] node=q.poll();

                       for(int i=0;i<dir.length;i++){
                           int neighborRow=node[0]+dir[i][0];
                           int neighborColumn=node[1]+dir[i][1];

                           if(neighborRow>=0 && neighborColumn>=0 && neighborRow<grid.length
                                   && neighborColumn<grid[0].length && visited[neighborRow][neighborColumn]!=1 && grid[neighborRow][neighborColumn]==1){
                               q.add(new int[]{neighborRow,neighborColumn});
                               visited[neighborRow][neighborColumn]=1;
                               area++;
                           }
                       }
                   }
                   if(area>maxArea){
                       maxArea=area;
                   }
               }
            }
        }
        return maxArea;
    }
}
