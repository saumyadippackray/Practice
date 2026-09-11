package org.example.neetcode.tries;

import java.lang.reflect.Array;
import java.util.*;

public class WordSearchII {
    TrieNode trieNode;
    private Set<String> res;
    private boolean[][] visit;
    public WordSearchII(){
        trieNode=new TrieNode();
    }
    public static void main(String[] args) {

        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchII solution = new WordSearchII();
        List<String> result = solution.findWords(board, words);

        System.out.println(result);
    }
    public List<String> findWords(char[][] board, String[] words) {
        visit = new boolean[board.length][board[0].length];
        res=new HashSet<>();
        for(String str:words)
        {
            addWordToTrie(str);
        }

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                dfs(board,row,col,trieNode,new StringBuilder());
            }
        }
        return new ArrayList<>(res);
    }
    private void dfs(char[][] board, int r, int c, TrieNode node, StringBuilder word) {
        if(r<0 || c<0 || r>=board.length || c>=board[0].length
        || visit[r][c]){
            return;
        }

        char ch = board[r][c];
        TrieNode next = node.children[ch - 'a'];

        if(next==null){
            return;
        }

        visit[r][c]=true;
        word.append(board[r][c]);

        if(next.endOfWord){
            res.add(word.toString());
        }

        dfs(board,r+1,c,next,word);
        dfs(board,r-1,c,next,word);
        dfs(board,r,c+1,next,word);
        dfs(board,r,c-1,next,word);

        visit[r][c]=false;
        word.deleteCharAt(word.length()-1);
    }
    public void addWordToTrie(String str){
        TrieNode curr=trieNode;
        for(char c:str.toCharArray()){
            if(curr.children[c - 'a']==null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.endOfWord=true;
    }
}
