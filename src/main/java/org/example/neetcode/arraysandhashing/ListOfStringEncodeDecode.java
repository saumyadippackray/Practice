package org.example.neetcode.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfStringEncodeDecode {
    public static void main(String[] args) {
        System.out.println(ListOfStringEncodeDecode.encode(new ArrayList<>(Arrays.asList("london", "tokyo", "newyork"))));
        System.out.println(ListOfStringEncodeDecode.decode(ListOfStringEncodeDecode.encode(new ArrayList<>(Arrays.asList("london", "tokyo", "newyork")))));
    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder=new StringBuilder();
        for(String str:strs)
            stringBuilder.append(str.length()).append("#").append(str);
        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        int i=0;
        List<String> retriveList=new ArrayList<>();
        while (i<str.length()){
            int j=i;
            while (str.charAt(j)!='#')
                j++;
            System.out.println("value of j"+j);
            int length=Integer.parseInt(str.substring(i,j));

            String retriveString=str.substring(j+1,j+1+length);
            retriveList.add(retriveString);
            i=j+1+length;
            System.out.println(retriveString);
        }
        return retriveList;
    }
}
