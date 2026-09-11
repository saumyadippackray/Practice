package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Interview {

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
            count=0;
        }
        return nonRepetativeChar;
    }

    public static void main(Integer[] args) throws Exception {
        Interview interview=new Interview();
       interview.findFirstNonRepetativeChar("inside circles");
    }
}
