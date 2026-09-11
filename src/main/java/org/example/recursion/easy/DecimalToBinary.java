package org.example.recursion.easy;

public class DecimalToBinary {
    public static int decToBin(int d) {
        if (d == 0)
            return 0;
        else
            return (d % 2 + 10 * decToBin(d / 2));
    }

    // Driver code
    public static void main(String[] args) {
        int d = 10;
        System.out.println(21 >> 1);
    }
}

//10 0+10*101=1010
//5  1+10*10=101
//2  0+10*1=10
//1  1+10*0=1
//0  0