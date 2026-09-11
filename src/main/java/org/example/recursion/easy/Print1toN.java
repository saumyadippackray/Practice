package org.example.recursion.easy;

public class Print1toN {
    public static void main(String[] args) {
        Print1toN print1toN=new Print1toN();
        print1toN.print(5);
    }
    public static void print(Integer nums){
        if(nums==0)
            return;

        print(nums-1);
        System.out.println(nums);
    }
}
