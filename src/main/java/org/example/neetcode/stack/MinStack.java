package org.example.neetcode.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()){
            minStack.push(val);
        }
        System.out.println(stack);
        System.out.println("min=="+minStack);
        //0 minStack=0
        //2 minStack=0
        //1 minStack=0
        //-1  minStack=0,-1
    }

    public void pop() {
        //0 2 1 -1 minStack=0,-1
        //pop -1   minStack=0
        if(stack.isEmpty()) return;
        int popValue=stack.pop();
        if(minStack.peek()==popValue)
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
