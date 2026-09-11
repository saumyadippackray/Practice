package org.example.neetcode.tries;

import org.example.neetcode.tree.TreeNode;

class PrefixTree {
    public static void main(String[] args) {
        PrefixTree prefixTree=new PrefixTree();
        prefixTree.insert("suman");
        System.out.println(prefixTree.search("sumann"));
        System.out.println(prefixTree.startsWith("suma"));
    }
    private TrieNode root;
    public PrefixTree() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(curr.children[i]==null){
                curr.children[i]=new TrieNode();
            }
            curr=curr.children[i];
        }
        curr.endOfWord=true;
    }

    public boolean search(String word) {
        TrieNode start=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(start.children[i]==null)
                return false;
            start=start.children[i];
        }
        if(start.endOfWord)
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode start=root;
        for(char c:prefix.toCharArray()){
            int i=c-'a';
            if(start.children[i]==null)
                return false;
            start=start.children[i];
        }

        return true;
    }
}

