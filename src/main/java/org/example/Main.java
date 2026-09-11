package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//      List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//      List<Integer> newList= list.stream().filter(li-> li>7).collect(Collectors.toList());
//      System.out.println(checkPrime(8));
//
//      user-> id nme
//
//              Adress->id adress user_id

        System.out.println("test");
        Main main=new Main();
        System.out.println(main.findFirstNonRepetativeChar("inside circles"));
    }
    String findFirstNonRepetativeChar(String str){
        String nonRepetativeChar="";
        int count=0;
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
            }
            if(count==0){
                    nonRepetativeChar= String.valueOf(str.charAt(i));
                    break;
            }
            System.out.println(nonRepetativeChar);
            count=0;
        }
        return nonRepetativeChar;
    }
//    public String xvowel(String str){
//
//    }
//
//    public boolean checkVowel(char c){//aeimoxy
//
//    }
}