package org.example.MultiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownlatchExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch=new CountDownLatch(3);
        executorService.execute(new SimpleThread(countDownLatch));
        executorService.execute(new SimpleThread(countDownLatch));
        executorService.execute(new SimpleThread(countDownLatch));
        executorService.execute(new SimpleThreadWithRunnable());
        countDownLatch.await();
        System.out.println("suman");
    }
}
