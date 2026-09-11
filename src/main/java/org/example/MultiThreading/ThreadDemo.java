//package org.example.MultiThreading;
//
//class Thread1 extends Thread{
//    public void run(){
//        for(int i=0;i<5;i++){
//            System.out.println("Hi");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//class Thread2 implements Runnable{
//    public void run(){
//        for(int i=0;i<5;i++){
//            System.out.println("Hello");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//}
//public class ThreadDemo {
//    public static void main(String[] args) {
//        Thread1 thread1=new Thread1();
//        Thread thread2=new Thread(new Thread2());
//        thread1.start();
//        thread2.start();
//    }
//}
