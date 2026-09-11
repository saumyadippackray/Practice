package org.example.Queue;

import org.example.LinkedList.Employee;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class QueueWithArray {
    private Employee[] queue;
    private int front;
    private int back;

    public QueueWithArray(int capacity){
        queue=new Employee[capacity];
    }

    public void push(Employee employee){
        if(queue.length==back){
            Employee[] newQueue=new Employee[2*queue.length];
            System.arraycopy(queue,0,newQueue,0,queue.length);
            queue=newQueue;
        }
        queue[back]=employee;
        back++;
    }

    public Employee pop(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Employee employee=queue[front];
        queue[front]=null;
        front++;
        if(isEmpty()){
            front=0;
            back=0;
        }
        return employee;
    }
    public Employee peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    boolean isEmpty(){
        if(back-front==0)
            return true;
        else
            return false;
    }

    public void print()
    {
        for (Employee employee:queue){
            System.out.println(employee);
        }
    }
}
