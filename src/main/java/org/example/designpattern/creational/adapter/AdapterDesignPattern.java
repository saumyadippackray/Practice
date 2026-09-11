package org.example.designpattern.creational.adapter;

public class AdapterDesignPattern {
    public static void main(String[] args) {

        Driver chromeDriver=new ChromeDriver();
        chromeDriver.selectElement();
        chromeDriver.getElement();
        IEDriver ieDriver=new IEDriver();
        ieDriver.clickElement();
        ieDriver.findElement();
        Driver ieDriverFromAdapter=new DriverAdapter(ieDriver);
        ieDriverFromAdapter.getElement();
        ieDriverFromAdapter.selectElement();
    }
}
