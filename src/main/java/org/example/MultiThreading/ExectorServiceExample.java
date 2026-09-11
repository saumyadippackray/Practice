package org.example.MultiThreading;

import java.util.concurrent.*;

public class ExectorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch=new CountDownLatch(3);
        executorService.execute(new SimpleThread(countDownLatch));
        executorService.execute(new SimpleThread(countDownLatch));
        Future<String> future=executorService.submit(new CallableExample2("suman",countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.get());
        executorService.shutdown();
    }

}
