package org.example.designpattern.creational.factory;

public class OperatingSystemFactory {
    public Os getInstance(String type){
        if(type.equals("linux"))
            return new Linux();
        else if(type.equals("ios"))
            return new Ios();
        else if(type.equals("android"))
            return new Android();
        else
            return null;
    }
}
