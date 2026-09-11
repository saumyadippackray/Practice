package org.example.graph;

import org.checkerframework.checker.units.qual.C;

import java.util.*;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };

//        ["X","X","X","X"],
//        ["X","O","O","X"],
//        ["X","X","O","X"],
//        ["X","O","X","X"]
        solveOptimized(board);
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    //We will first mark 0 in the edge if other O connected with edge 0 in that case it will not surrounded by X otherwise it is
    public static void solveOptimized(char[][] board){
        int[][] neighbours={{-1,0},
                {0,-1},
                {1,0},
                {0,1}};
        int ROW=board.length;
        int COL=board[0].length;
        Queue<int[]> q = new LinkedList<>();

        //mark edge rows with 0

        for (int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if((r==0 || c==0 || r==ROW-1 || c==COL-1) && board[r][c]=='O'){
                    q.add(new int[]{r,c});
                }
            }
        }

        while (!q.isEmpty()){
            int[] node=q.poll();
            board[node[0]][node[1]]='T';

            for(int[] neighbour:neighbours) {
                int neighbourRow = node[0] + neighbour[0];
                int neighbourCol = node[1] + neighbour[1];
                if(neighbourRow>=0 && neighbourCol>=0 && neighbourRow<ROW && neighbourCol<COL && board[neighbourRow][neighbourCol]=='O'){
                    q.add(new int[]{neighbourRow,neighbourCol});
                }
            }
        }

        for (int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                    if(board[r][c]=='T'){
                        board[r][c]='O';
                    }
                    else if(board[r][c]=='O'){
                        board[r][c]='X';
                    }
                }
            }
    }
    public static void solve(char[][] board) {
        int[][] neighbours={{-1,0},
                {0,-1},
                {1,0},
                {0,1}};
        int ROW=board.length;
        int COL=board[0].length;
        boolean[][] isVisited=new boolean[ROW][COL];
        Queue<int[]> q=new LinkedList<>();

        for (int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                List<List<Integer>> sorroundedList=new ArrayList<>();
                boolean isSorrounded=true;
                if(board[r][c]=='O' && !isVisited[r][c]) {
                    q.add(new int[]{r,c});
                    while (!q.isEmpty()) {
                        int[] node=q.poll();
                        sorroundedList.add(Arrays.asList(node[0],node[1]));
                        for(int[] neighbour:neighbours){
                            int neighbourRow=node[0]+neighbour[0];
                            int neighbourCol=node[1]+neighbour[1];

                            if(neighbourRow>=0 && neighbourCol>=0 && neighbourRow<ROW && neighbourCol<COL && board[neighbourRow][neighbourCol] !='X'
                                    && !isVisited[neighbourRow][neighbourCol]){
                                isVisited[neighbourRow][neighbourCol]=true;
                                q.add(new int[]{neighbourRow,neighbourCol});
                                sorroundedList.add(Arrays.asList(neighbourRow,neighbourCol));
                            }
                            else if(neighbourRow<0 || neighbourCol<0 || neighbourRow>=ROW || neighbourCol>=COL){
                                isSorrounded=false;
                            }
                        }
                    }
                }
                if(isSorrounded){
                    for(List<Integer> s:sorroundedList){
                        board[s.get(0)][s.get(1)]='X';
                    }
                }
            }
        }
    }
}
