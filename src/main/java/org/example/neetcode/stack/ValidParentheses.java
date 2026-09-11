package org.example.neetcode.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid(""));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> bracketsMap=new HashMap<>();
        bracketsMap.put(')','(');
        bracketsMap.put('}','{');
        bracketsMap.put(']','[');

        for(char bracket:s.toCharArray()){
            if(bracketsMap.containsKey(bracket)){
                if(!stack.isEmpty() && stack.peek()==bracketsMap.get(bracket)){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else {
                stack.push(bracket);
            }
        }

        return stack.isEmpty();
    }
}

//([{}])
//Will use stack first add all closing brackets ana their corrosponding closing brackets in a map \
// after that we will put the all opening brackets in a stack and when closing brackets start we will peek from the stack if value is not there we will return false
// ([{}])
//closeToOpen.put(')', '(');
//        closeToOpen.put(']', '[');
//        closeToOpen.put('}', '{');
// (     ---stack= ( --- each time we will check if the brackets is there in map
// ([    ---stack= ([
// ([{   ---stack= ([{
// ([{}  ---stack= ([{ --- Now the } is there in hashmap so we check the stack for its value it is there so we pop the stack and remove the { new stack= ([
// ([{}] ---stack= ([  --Now the ] is there in hashmap so we check the stack for its value it is there so we pop the stack and remove the [ new stack= (
// ([{}]) ---stack= (  --Now the ) is there in hashmap so we check the stack for its value it is there so we pop the stack and remove the ) new stack= EMPTY
