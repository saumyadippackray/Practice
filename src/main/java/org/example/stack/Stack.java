package org.example.stack;

import org.example.LinkedList.Employee;

public class Stack {
    public static void main(String[] args) {
        LinkedStack linkedStack=new LinkedStack();
        linkedStack.push(new Employee(1,"suman1"));
        linkedStack.push(new Employee(2,"suman2"));
        linkedStack.push(new Employee(3,"suman3"));
        linkedStack.print();
        System.out.println();
        linkedStack.peek();
        linkedStack.print();
        System.out.println();
        linkedStack.pop();
        linkedStack.print();
    }
}
