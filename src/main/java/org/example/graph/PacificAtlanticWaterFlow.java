package org.example.graph;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int height[][]={
              {4,2,7,3,4},
              {7,4,6,4,7},
              {6,3,5,3,6}
        };
        System.out.println(pacificAtlantic(height));
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW=heights.length;
        int COL=heights[0].length;
        List<List<Integer>> result=new ArrayList<>();
        boolean[][] pacificVisit=new boolean[ROW][COL];
        boolean[][] atlanticVisit=new boolean[ROW][COL];

        Queue<int[]> pacificQueue=new LinkedList<>();
        Queue<int[]> atlanticQueue=new LinkedList<>();

        for(int i=0;i<ROW;i++){
            pacificQueue.add(new int[]{i,0});
            atlanticQueue.add(new int[]{i,COL-1});
        }

        for(int i=0;i<COL;i++){
            pacificQueue.add(new int[]{0,i});
            atlanticQueue.add(new int[]{ROW-1,i});
        }
        bfs(pacificVisit,pacificQueue,heights);
        bfs(atlanticVisit,atlanticQueue,heights);
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(pacificVisit[i][j] && atlanticVisit[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public static void bfs(boolean[][] isVisited,Queue<int[]> queue,int[][] heights){
        int[][] neighbours={{-1,0},
                {0,-1},
                {1,0},
                {0,1}};
        while (!queue.isEmpty()){
            int[] node=queue.poll();
            int nodeRow=node[0];
            int nodeColumn=node[1];
            isVisited[nodeRow][nodeColumn]=true;
            for(int[] neighbour:neighbours){
                int neighbourRow=nodeRow+neighbour[0];
                int neighbourCol=nodeColumn+neighbour[1];

                if(neighbourRow>=0 && neighbourCol>=0 && neighbourRow<heights.length && neighbourCol<heights[0].length &&
                heights[nodeRow][nodeColumn]<=heights[neighbourRow][neighbourCol] && !isVisited[neighbourRow][neighbourCol]){
                    queue.add(new int[]{neighbourRow,neighbourCol});

                }
            }
        }
    }
}
