package org.example.recursion.striver;

public class SumOfTheFirstNNumber {
    public static void main(String[] args) {
        SumOfTheFirstNNumber sumOfTheFirstNNumber=new SumOfTheFirstNNumber();
        System.out.println(sumOfTheFirstNNumber.factorial(4));
    }

    public int dfs(int n,int sum){
        if(n<1)
            return sum;
        //sum=sum+i;
        return dfs(n-1,sum+n);
    }

    public int dfsWithOutParameter(int n){
        if(n<1)
            return 0;
        //sum=sum+i;
        return n+dfsWithOutParameter(n-1);
    }

    public int factorial(int n){
        if(n==1)
            return 1;
        return n*factorial(n-1);
    }
}
