package org.example.Serialization;

import org.example.test.Test;

import java.io.*;
import java.lang.reflect.Field;

public class SerialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestClass testClass=new TestClass();
        testClass.i=4;
        File f =new File("obj.text");
        FileOutputStream fileOutputStream=new FileOutputStream(f);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(testClass);

        FileInputStream fileInputStream=new FileInputStream(f);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        TestClass obj=(TestClass)objectInputStream.readObject();
        System.out.println(obj.i);
    }
}
class TestClass implements Serializable{
    int i;

}