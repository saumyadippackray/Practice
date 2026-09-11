package org.example.designpattern.creational.adapter;

public class DriverAdapter implements Driver{
    IEDriver ieDriver;
    public DriverAdapter(IEDriver ieDriver){
        this.ieDriver=ieDriver;
    }
    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}
