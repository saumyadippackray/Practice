package org.example.LamdaExpression;

@FunctionalInterface
interface TestInterfaceLamda{
    int add(int i,int j);
}
public class TestLamda{
    public static void main(String[] args) {
        TestInterfaceLamda testInterfaceLamda= (i,j) ->{
            System.out.println("suman"+i+j);
            return i+j;
        };
        testInterfaceLamda.add(1,2);
    }
}
