package org.example.neetcode.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "SEE";
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c< board[0].length;c++){
                if(isWordExist(board,word,board.length, board[0].length,r,c,0 ))
                    return true;
            }
        }
        return false;
    }

    public static boolean isWordExist(char[][] board, String word,int rowLength,int columnLength,int r,int c,int i){
        if(i==word.length())
            return true;

        if(r<0 || c<0 || r>rowLength-1 || c>columnLength-1 || board[r][c] == '#' || board[r][c] !=word.charAt(i))
            return false;

        board[r][c]='#';
        boolean res=isWordExist(board,word,rowLength,columnLength,r,c+1,i+1) ||
                isWordExist(board,word,rowLength,columnLength,r,c-1,i+1) ||
                isWordExist(board,word,rowLength,columnLength,r+1,c,i+1) ||
                isWordExist(board,word,rowLength,columnLength,r-1,c,i+1);
        board[r][c]=word.charAt(i);
        return res;
    }
}

//1 2 3
//4 5 6
//7 8 9