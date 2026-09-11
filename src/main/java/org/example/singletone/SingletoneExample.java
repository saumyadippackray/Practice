package org.example.singletone;

public class SingletoneExample {
    private static SingletoneExample singletoneExample;
    private SingletoneExample(){

    }
    public static SingletoneExample getInstance(){
        if(singletoneExample==null)
            singletoneExample=new SingletoneExample();
        return singletoneExample;
    }
}
class Main{
    public static void main(String[] args) {
        SingletoneExample singletoneExample=SingletoneExample.getInstance();
    }
}
