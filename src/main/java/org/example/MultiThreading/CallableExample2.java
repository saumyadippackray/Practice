package org.example.MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class CallableExample2 implements Callable {
    String name;
    CountDownLatch countDownLatch;
    public CallableExample2(String name,CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch=countDownLatch;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        countDownLatch.countDown();
        return name;
    }
}
