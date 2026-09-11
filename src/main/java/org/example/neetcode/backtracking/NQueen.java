package org.example.neetcode.backtracking;

import java.util.*;

public class NQueen {

    Set<Integer> cols=new HashSet<>();
    Set<Integer> positiveDiagonal=new HashSet<>();
    Set<Integer> negativeDiagonal=new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        NQueen nQueen=new NQueen();
        System.out.println(nQueen.solveNQueens(4));
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];

        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        backTrack(0,n,board);
        return res;
    }

    public void backTrack(int row,int n,char[][] board){
        if(row==n){
            List<String> resultRow=new ArrayList<>();

            for(char[] r:board){
                resultRow.add(new String(r));
            }
            res.add(resultRow);
            return;
        }

        for(int col=0;col<n;col++){
            if(cols.contains(col) || positiveDiagonal.contains(row+col) || negativeDiagonal.contains(row-col))
                continue;

            cols.add(col);
            positiveDiagonal.add(row+col);
            negativeDiagonal.add(row-col);

            board[row][col]='Q';

            backTrack(row+1,n,board);

            cols.remove(col);
            positiveDiagonal.remove(row+col);
            negativeDiagonal.remove(row-col);

            board[row][col]='.';
        }
    }
}


