package org.example.MultiThreading;

public class SimpleThreadWithRunnable implements Runnable{
        int values[] = {1, 2, 3, 4};

        public void run() {
            for (int i : values) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    public static void main(String[] args) {
        Thread thread=new Thread(new SimpleThreadWithRunnable());
        thread.start();
    }
}
