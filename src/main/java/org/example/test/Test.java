package org.example.test;

public class Test {
    public static void main(String[] args)
    {
        C1 c3 = new C3();
        c3.f1();
    }
}
 class C1
{
    void f1(){
        System.out.println("f1 in class C1");
    }
}
 class C2 extends C1
{
    void f1() {
        System.out.println("f1 in class C2");
    }
}
 class C3 extends C2
{
    void f1() {
        System.out.println("f1 in class C3");
    }
}

