package org.example.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        numIslands(grid);
    }
    public static int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q=new LinkedList<>();
        int count=0;

        int[][] dir={
                {-1,0},//up
                {1,0},//down
                {0,1},//right
                {0,-1}//left
        };

        for(int row=0;row<grid.length;row++){
            for (int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1' && visited[row][col]!=1){
                    count++;
                    q.add(new int[]{row, col});
                    while (!q.isEmpty()){
                        int[] node=q.poll();
                        for (int deltaRow=0;deltaRow<dir.length;deltaRow++){
                                int neighborCol=node[1]+dir[deltaRow][1];
                                int neighborRow=node[0]+dir[deltaRow][0];

                                if(neighborCol>=0 && neighborRow>=0 && neighborRow<grid.length && neighborCol<grid[0].length && grid[neighborRow][neighborCol]=='1'
                                        && visited[neighborRow][neighborCol]!=1){
                                    q.add(new int[]{neighborRow,neighborCol});
                                    visited[neighborRow][neighborCol]=1;
                                }
                        }
                    }
                }
            }
        }
        return count;
    }
    public static int numIslandsWithAllDir(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q=new LinkedList<>();
        int count=0;

        for(int row=0;row<grid.length;row++){
            for (int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='1' && visited[row][col]!=1){
                    count++;
                    q.add(new int[]{row, col});
                    while (!q.isEmpty()){
                        int[] node=q.poll();
                        for (int deltaRow=-1;deltaRow<=1;deltaRow++){
                            for (int deltaCol=-1;deltaCol<=1;deltaCol++){
                                int neighborCol=node[1]+deltaCol;
                                int neighborRow=node[0]+deltaRow;

                                if(neighborCol>=0 && neighborRow>=0 && neighborRow<grid.length && neighborCol<grid[0].length && grid[neighborRow][neighborCol]=='1'
                                        && visited[neighborRow][neighborCol]!=1){
                                    q.add(new int[]{neighborRow,neighborCol});
                                    visited[neighborRow][neighborCol]=1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
