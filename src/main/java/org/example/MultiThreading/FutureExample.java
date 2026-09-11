package org.example.MultiThreading;

import java.util.concurrent.*;

class CallableExample implements Callable<Integer>{
    private int i;
    public CallableExample(int i){
        this.i=i;
    }

    @Override
    public Integer call() throws Exception {
        int sum=0;
       for(int num=0;num<i;num++){
           sum=sum+num;
           System.out.println("++++++++++++++++++++++++++"+num);
       }
       return sum;
    }
}
public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        Future<Integer> future=executorService.submit(new CallableExample(1000));
        future.get();
        for (int i=0;i<1000;i++){
            System.out.println("----------------------------------"+i);
        }
    }


}
