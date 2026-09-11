package org.example.MultiThreading;

class TestSynchronized{
    int count=0;
    public synchronized void increment(){
        count++;
    }
}
public class Synchronized {
    public static void main(String[] args) throws InterruptedException {
        TestSynchronized testSynchronized=new TestSynchronized();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    testSynchronized.increment();
                }
            }
        });
        Thread t2=new Thread(() -> {
            for(int i=0;i<1000;i++){
                testSynchronized.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(testSynchronized.count);
    }
}
