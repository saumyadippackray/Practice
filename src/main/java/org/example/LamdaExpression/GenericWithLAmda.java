package org.example.LamdaExpression;

interface Add <T>{
    T add(T i,T j);
}
public class GenericWithLAmda {
    public static void main(String[] args) {
        Add<Integer> add=(Integer i,Integer j)-> i+j;
        System.out.println(add.add(10,12));
    }
}
