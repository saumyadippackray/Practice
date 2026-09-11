package org.example.MultiThreading;

import java.util.concurrent.CountDownLatch;

public class SimpleThread extends Thread{
    int values[]={1,2,3,4};
    CountDownLatch countDownLatch;
    public SimpleThread(CountDownLatch countDownLatch){
        this.countDownLatch=countDownLatch;
    }
    public void run(){
        for(int i:values){
            System.out.println(i);
        }
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
//        Thread newThread=new SimpleThread();
//        newThread.start();
    }
}

