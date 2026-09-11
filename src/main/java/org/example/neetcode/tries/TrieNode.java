package org.example.neetcode.tries;

public class TrieNode {
    TrieNode[] children ;
    boolean endOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}