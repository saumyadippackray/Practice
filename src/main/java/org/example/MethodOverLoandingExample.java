package org.example;

import java.sql.SQLException;

class overLoading1{
    public void testMethod(){
        System.out.println("I am in method 1");
    }
}
class overLoading2 extends overLoading1{
    public void testMethod() {
        System.out.println("I am in method 2");
    }
}
class overLoading3 extends overLoading1{
    public void testMethod(){
        System.out.println("I am in method 3");
    }
}
public class MethodOverLoandingExample {
    public static void main(String[] args) {
//        overLoading1 overLoading1=new overLoading2();
//
//        overLoading1.testMethod();
        int n1 = 5, n2 = 10, max;

        System.out.println("First num: " + n1);
        System.out.println("Second num: " + n2);

        // Largest among n1 and n2
        //max = (n1 > n2) ? n1 || (n1<n2) ? n2: n2;
    }

}
