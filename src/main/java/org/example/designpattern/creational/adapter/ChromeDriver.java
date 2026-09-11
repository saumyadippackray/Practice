package org.example.designpattern.creational.adapter;

public class ChromeDriver implements Driver{
    @Override
    public void getElement() {
        System.out.println("I am from chrome driver get method");
    }

    @Override
    public void selectElement() {
        System.out.println("I am from chrome driver select method");
    }
}
