package org.example.neetcode.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println(EvaluateReversePolishNotation.evalRPN(new String[]{"1","2","+","3","*","4","-"}));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(String token:tokens){
            if(token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            } else if (token.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if (token.equals("-")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b-a);
            }
            else if (token.equals("/")){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b/a);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}

//["1","2","+","3","*","4","-"]
//We will take a stack and if the string is a number we will put the number into the stack and when the input is a operator we take out two number from stack and
//do the operation and push back into the stack
// stack-[1]
// stack-[1,2]
// Now we have got a operator + we take two element from the stack and do the operation so the new stack will be - [3]
// stack-[3,3]
// Now we have got a operator * we take two element from the stack and do the operation so the new stack will be - [9]
// stack-[9,4]
// Now we have got a operator - we take two element from the stack and do the operation so the new stack will be - [5]