package org.example.MultiThreading;

class InterThreadCommunicationDemoTest{
    int num;
    boolean valueSet=false;
    public synchronized void put(int num) throws InterruptedException {
        while (valueSet){
            wait();
        }
        System.out.println("put"+num);
        this.num=num;
        valueSet=true;
        notify();
    }
    public synchronized void get() throws InterruptedException {
        while (!valueSet){
            wait();
        }
        System.out.println("get"+num);
        valueSet=false;
        notify();
    }
}
class Producer implements Runnable{
    InterThreadCommunicationDemoTest interThreadCommunicationDemoTest;
    public Producer(InterThreadCommunicationDemoTest interThreadCommunicationDemoTest) {
        this.interThreadCommunicationDemoTest=interThreadCommunicationDemoTest;
        Thread thread=new Thread(this,"Producer");
        thread.start();
    }
    public void run(){
        int i=0;
        while (true){
            try {
                interThreadCommunicationDemoTest.put(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
class Consumer implements Runnable{
    InterThreadCommunicationDemoTest interThreadCommunicationDemoTest;
    public Consumer(InterThreadCommunicationDemoTest interThreadCommunicationDemoTest) {
        this.interThreadCommunicationDemoTest=interThreadCommunicationDemoTest;
        Thread thread=new Thread(this,"Consumer");
        thread.start();
    }
    public void run(){
        while (true){
            try {
                interThreadCommunicationDemoTest.get();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class InterThreadCommunicationDemo {
    public static void main(String[] args) {
        InterThreadCommunicationDemoTest interThreadCommunicationDemoTest=new InterThreadCommunicationDemoTest();
        new Producer(interThreadCommunicationDemoTest);
        new Consumer(interThreadCommunicationDemoTest);
    }

}
