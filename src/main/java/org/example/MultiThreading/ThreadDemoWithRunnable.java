package org.example.MultiThreading;

public class ThreadDemoWithRunnable {
    public static void main(String[] args) throws InterruptedException {
        //Using anonymous inner class Thread thread=new Thread(){}
        Thread thread= new Thread(() -> {
            for(int i=0;i<5;i++){
                System.out.println("Hi");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //Using anonymous inner interface
        Runnable runnable= () -> {
            for(int i=0;i<5;i++){
                System.out.println("Hello");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread2=new Thread(runnable,"Hello Thread");

        thread.setName("Hi Thread"); // To set the name of thread
        thread.setName("Hello Thread");
        System.out.println(thread2.getName());// To get name
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        //thread.join();
        Thread.sleep(500);
        thread2.start();
        System.out.println("is alive"+thread.isAlive()); //To check if the thread is alive
        thread2.join(); //java.lang.Thread class provides the join() method which allows one thread to wait until another thread completes its execution.

        System.out.println("I am executing main");
    }
}
