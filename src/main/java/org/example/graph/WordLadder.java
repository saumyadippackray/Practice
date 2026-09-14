package org.example.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = new ArrayList<>(List.of("hot","dog"));
        WordLadder wordLadder=new WordLadder();
        System.out.println(wordLadder.ladderLength(beginWord,endWord,wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord))
            return 0;
        Map<String,List<String>> nei=new HashMap<>();
        wordList.add(beginWord);
        for(String word:wordList){
            for (int i=0;i<word.length();i++){
                String pattern=word.substring(0,i)+"*"+word.substring(i+1);
                nei.computeIfAbsent(pattern,k->new ArrayList<>()).add(word);
            }
        }
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        Set<String> visited=new HashSet<>();
        int res=1;
        while (!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                String word=q.poll();
                if(word.equals(endWord))
                    return res;
                for(int j=0;j<word.length();j++){
                    String pattern=word.substring(0,j)+"*"+word.substring(j+1);
                    for(String str:nei.getOrDefault(pattern,Collections.emptyList())){
                        if(!visited.contains(str)){
                            q.offer(str);
                            visited.add(str);
                        }
                    }
                }
            }
            res++;
        }


        return 0;
    }
}
