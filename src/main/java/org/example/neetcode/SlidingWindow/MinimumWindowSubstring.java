package org.example.neetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
    }
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int startPointer = 0;
        int tMatch ;
        int sMatch = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);

            sMap.put(t.charAt(i), 0);
        }
        tMatch = countT.size();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(res);
            if (sMap.get(s.charAt(i)) != null) {
                System.out.println("char at" + s.charAt(i) + "" + countT.get(s.charAt(i)));
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
                if (sMap.get(s.charAt(i)).intValue() == countT.get(s.charAt(i)).intValue()) sMatch++;
            }
            //OUZOD YXAZV
            //when we will get the count match in this case OUZODYX in this substring every char of xyz is there now we will shrink the string from the starting
                while (tMatch == sMatch) {
                    System.out.println(res);
                    if ((i - startPointer + 1) < resLen) {
                        res[0] = startPointer;
                        res[1] = i;
                        resLen = i - startPointer + 1;
                    }
                    if (sMap.get(s.charAt(startPointer)) != null) {
                        sMap.put(s.charAt(startPointer), sMap.get(s.charAt(startPointer)) - 1);
                        if (sMap.get(s.charAt(startPointer)) < countT.get(s.charAt(startPointer))) {
                            System.out.println("smatch before"+sMatch);
                            sMatch=sMatch-1;
                            System.out.println("smatch after"+sMatch);}


                    }
                    startPointer++;
                }
        }
        if (res[0] == -1) return "";
        return s.substring(res[0],res[1]+1);
    }
}


// s = "OUZODYXAZV", t = "XYZ"
//add the count of each char of t in two hashmap and one hashmap we have to add the count also and in one hashmap we will set all values as 0
// basically we are just care about the conut of t
// Now start two pointer both from start
// increase the second counter by 1 and add the char into the hashmap if that char is already is in the hashmap
// and check if the count is matching with the t's count if the count matchs we will increase the value of smatch(tmatch size is the same as countT) and compare
// the value with tmatch is equal or not is euqual then we will move the first pointer to shrink the window and will modify the smatch value and do until
// the Smatch!=Smatch