package org.example.stack;

import org.example.LinkedList.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {
    private LinkedList<Employee> stack;

    public LinkedStack(){
        stack=new LinkedList<>();
    }
    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void print(){
        ListIterator<Employee> listIterator=stack.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next());
        }
    }
}
