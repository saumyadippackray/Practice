package org.example.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasure {
    private int[][] directions = {{1, 0}, {-1, 0},
            {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private int ROWS, COLS;
        public static void main(String[] args) {
                    int[][]  grid={
            {2147483647,-1,0,2147483647},
            {2147483647,2147483647,2147483647,-1},
            {2147483647,-1,2147483647,-1},
            {0,-1,2147483647,2147483647}
            };

//            [3,-1,0,1],
//            [2,2,1,-1],
//            [1,-1,2,-1],
//            [0,-1,3,4]]

            IslandAndTreasure islandAndTreasure=new IslandAndTreasure();
            islandAndTreasure.islandsAndTreasure(grid);
            for (int[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
        }
        public void islandsAndTreasure(int[][] grid) {
            int[][] directions = {{1, 0}, {-1, 0},
                    {0, 1}, {0, -1}};
            int INF = 2147483647;
            int rows=grid.length;
            int columns=grid[0].length;
            Queue<int[]> q=new LinkedList<>();
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    if(grid[i][j]==0) {
                        q.add(new int[]{i,j});
                    }
                }
            }
            int count=0;
            while (!q.isEmpty()){

                for(int i=0;i<q.size();i++){
                    int[] node=q.poll();
                    for(int[] dir:directions){
                        int neighborRow=node[0]+dir[0];
                        int neighborColumns=node[1]+dir[1];

                        if(neighborRow>=0 && neighborRow<rows && neighborColumns>=0 && neighborColumns<columns &&
                        grid[neighborRow][neighborColumns] == INF){
                            q.add(new int[]{neighborRow,neighborColumns});
                            grid[neighborRow][neighborColumns]=grid[node[0]][node[1]]+1;
                        }
                    }
                }
            }
        }
        public void islandsAndTreasureBootForce(int[][] grid) {
            ROWS=grid.length;
            COLS=grid[0].length;

            for(int i=0;i<ROWS;i++){
                for(int j=0;j<COLS;j++){
                    if(grid[i][j]==INF) {
                        grid[i][j] = bfs(grid, i, j);
                    }
                }
            }
        }

        public int bfs(int[][] grid,int row,int column){
            Queue<int[]> q=new LinkedList<>();
            int[][] visitedQueue=new int[grid.length][grid[0].length];
            int distance=0;
            q.add(new int[]{row,column});
            visitedQueue[row][column]=1;

            while (!q.isEmpty()){
                int size = q.size();

                // Process one complete BFS level
                for (int i = 0; i < size; i++) {
                    int[] node = q.poll();

                    for (int[] dir : directions) {
                        int neighborRow = dir[0] + node[0];
                        int neighborColumn = dir[1] + node[1];

                        if (neighborRow >= 0 && neighborRow < ROWS && neighborColumn >= 0 && neighborColumn < COLS && grid[neighborRow][neighborColumn] != -1
                                && visitedQueue[neighborRow][neighborColumn] != 1) {
                            q.add(new int[]{neighborRow, neighborColumn});
                            visitedQueue[neighborRow][neighborColumn] = 1;
                            if (grid[neighborRow][neighborColumn] == 0)
                                return distance + 1;
                        }
                    }
                }
                distance++;
            }
            return Integer.MAX_VALUE;
        }
}
