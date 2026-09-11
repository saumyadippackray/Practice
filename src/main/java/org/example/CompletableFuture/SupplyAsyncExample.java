package org.example.CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class SupplyAsyncExample {
    public Void fetchEmployee(){
        Executor executor= Executors.newCachedThreadPool();
        CompletableFuture<Void> completableFuture=CompletableFuture.supplyAsync(()->{
            List<Employee> employee=GetEmployee.getEmployee();
            System.out.println(employee);
            return employee;
        },executor).thenApply(
                (employees)->{
                    return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
                            .collect(Collectors.toList());
                }
        ).thenApply(
                (employees)->{
                    return employees.stream().map(Employee::getEmail)
                            .collect(Collectors.toList());
                }
        ).thenAccept(emails->{
            emails.forEach((email)->System.out.println(email));
        });
        try {
            Void f=completableFuture.get();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            return f;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        SupplyAsyncExample supplyAsyncExample=new SupplyAsyncExample();
        supplyAsyncExample.fetchEmployee();
    }
}
