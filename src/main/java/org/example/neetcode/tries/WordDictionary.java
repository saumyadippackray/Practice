package org.example.neetcode.tries;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary wordDictionary=new WordDictionary();
        wordDictionary.addWord("suman");
        System.out.println(wordDictionary.search(".uman"));
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode();
            }
            cur=cur.children[c-'a'];
        }
        cur.endOfWord=true;
    }

    public boolean search(String word) {

        return dfsSearch(word,root,0);
    }
    public boolean dfsSearch(String word,TrieNode root,int j) {
        TrieNode cur=root;
        for(int i=j;i<word.length();i++){

            if(word.charAt(i)=='.'){
                for(TrieNode trieNode:cur.children){
                    if(trieNode!=null && dfsSearch(word,trieNode,i+1)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if(cur.children[word.charAt(i)-'a']==null){
                    return false;
                }
                cur=cur.children[word.charAt(i)-'a'];
            }
        }
        return cur.endOfWord;
    }

}
