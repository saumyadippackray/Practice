package org.example.neetcode.arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '1', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '2', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(ValidSudoku.isValidSudokuOptimized(board));
    }

    public static boolean isValidSudokuOptimized(char[][] board) {
        Map<Integer,HashSet<Character>> rowMap=new HashMap<>();
        Map<Integer,HashSet<Character>> columnMap=new HashMap<>();
        Map<String,HashSet<Character>> squreMap=new HashMap<>();
        for(int row=0;row<9;row++){
            for(int column=0;column<9;column++){
                String squreKey=(row/3)+"-"+(column/3);
                if(board[row][column]=='.') continue;
                if(rowMap.computeIfAbsent(row,k->new HashSet<>()).contains(board[row][column]) ||
                        columnMap.computeIfAbsent(column,k->new HashSet<>()).contains(board[row][column]) ||
                        squreMap.computeIfAbsent(squreKey,k->new HashSet<>()).contains(board[row][column])){
                    return false;
                }
                rowMap.get(row).add(board[row][column]);
                columnMap.get(column).add(board[row][column]);
                squreMap.get(squreKey).add(board[row][column]);
            }
        }
        return true;
    }
    public static boolean isValidSudokuBootForce(char[][] board) {
        for(int row=0;row<9;row++){
            Set<Character> seen=new HashSet<>();
            for(int column=0;column<9;column++){
                if (board[row][column]=='.') continue;
                else if(seen.contains(board[row][column])){
                    return false;
                }
                seen.add(board[row][column]);
            }
        }

        for(int column=0;column<9;column++){
            Set<Character> seen=new HashSet<>();
            for(int row=0;row<9;row++){
                if (board[row][column]=='.') continue;
                else if(seen.contains(board[row][column])){
                    return false;
                }
                seen.add(board[row][column]);
            }
        }

        for(int square =0;square <9;square ++){
            for(int i=0;i<3;i++){
                Set<Character> seen=new HashSet<>();
                for(int j=0;j<3;j++) {
                    int row=(square/3)*3+i;
                    int column=(square%3)*3+j;
                    if (board[row][column] == '.') continue;
                    else if (seen.contains(board[row][column])) {
                        return false;
                    }
                    seen.add(board[row][column]);
                }
            }
        }
        

        return true;
    }
}

//1 2 3 4
//2 2 4 5
//3 5 6 7
//first have to check the each row after that each column and after the each 3*3 square. To check the element in square we have to do row/3,column/3