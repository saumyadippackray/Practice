package org.example.designpattern.creational.factory;

public class Linux implements Os{

    @Override
    public void getSpec() {
        System.out.println("I am Linux");
    }
}
