package org.example.neetcode.arraysandhashing;

import java.util.*;

public class GroupAnagrams {
    //["act","pots","tops","cat","stop","hat"]
    public static void main(String[] args) {
        String[] str= new String[]{"suman","suman","tuki","kitu"};
        GroupAnagrams groupAnagrams=new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(str));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str:strs){
            int[] arr=new int[26];
            for(int i=0;i<str.length();i++){
                arr[str.charAt(i)-'a']++;
            }
            String key=Arrays.toString(arr);
            res.putIfAbsent(key,new ArrayList<>());
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}

//"suman","suman","tuki","kitu"
//what we do here we put this string's char in a array of size 26 according to there index for index do the charat(i)-'a' so for c the index will be 2 and after that
//we convert that array as string and use that as the key of map and add the string into the value
