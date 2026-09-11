package org.example.recursion;

public class FibonacciSeries {
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries=new FibonacciSeries();
        System.out.println(fibonacciSeries.fib(6 ));
    }

    public int fib(int n)
    {
        // Stop condition
        if (n == 0)
            return 0;

        // Stop condition
        if (n == 1 || n == 2)
            return 1;

            // Recursion function
        else
            return (fib(n - 1) + fib(n - 2));
    }
}
