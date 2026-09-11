package org.example.Queue;

import org.example.LinkedList.Employee;

public class Queue {
    public static void main(String[] args) {
        QueueWithArray queueWithArray=new QueueWithArray(2);
        queueWithArray.push(new Employee(1,"suman1"));
        queueWithArray.push(new Employee(2,"suman2"));
        queueWithArray.push(new Employee(3,"suman3"));
        queueWithArray.pop();
        System.out.println(queueWithArray.peek());
        Queue queue=new Queue();
        //queueWithArray.print();
    }
}
