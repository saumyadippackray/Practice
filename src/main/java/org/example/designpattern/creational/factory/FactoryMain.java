package org.example.designpattern.creational.factory;

public class FactoryMain {
    public static void main(String[] args) {
        OperatingSystemFactory operatingSystemFactory=new OperatingSystemFactory();
        Os os=operatingSystemFactory.getInstance("linux");
        os.getSpec();
    }
}
