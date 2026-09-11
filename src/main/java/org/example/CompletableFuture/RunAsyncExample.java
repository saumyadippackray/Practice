package org.example.CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RunAsyncExample {
    public Void saveEmployee() throws ExecutionException, InterruptedException {
        Executor executor= Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            List<Employee> employee=GetEmployee.getEmployee();
            System.out.println(employee);
        },executor);
        return completableFuture.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsyncExample runAsyncExample=new RunAsyncExample();
        runAsyncExample.saveEmployee();
    }
}
