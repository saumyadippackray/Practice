package org.example.leetCode;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(GroupAnagram.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashMapList=new HashMap<>();
        for (String str:strs)
        {
            int[] charCount=new int[26];
            for(char c:str.toCharArray())
                charCount[c-'a']++;
            String key = Arrays.toString(charCount);
            hashMapList.putIfAbsent(key,new ArrayList<>());
            hashMapList.get(key).add(str);
        }
        return new ArrayList<>(hashMapList.values());

    }
}

//
//Input: strs = ["act","pots","tops","cat","stop","hat"]
//
//        Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]