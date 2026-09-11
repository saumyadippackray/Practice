package org.example.neetcode.stack;


import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76});
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result= new int[temperatures.length];
        Stack<Integer> temStack=new Stack();
        for(int i=temperatures.length-1;i>=0;i--){
            while(!temStack.isEmpty() && temperatures[i]>=temperatures[temStack.peek()]){
                temStack.pop();
            }
            if(!temStack.isEmpty() && temperatures[temStack.peek()]!=temperatures[i]){
                result[i]=temStack.peek()-i;
            }
            else {
                result[i]=0;
            }


            temStack.push(i);

        }
        return result;
    }
}
//89,62,70,58,47,47,46,76
//Input: temperatures = [89,62,70,58,47,47,46,76]
// We have to maintain a stack where we will save index of corrosponding number. Basically we will save the
// next highest number and will start from the end.
// 76 stack[]- There is no element in stack so first result will be 0

// 46 stack[76]- We will peek the stack and will get the 76 the difference between index is 1 so the result will be 1
//and we will push the element in stack so the new stack will be [76,46]

// 47 stack[76,46] - We will remove all element from stack which are equal or less than 47 so the stack is [76] and the result
// 2 and push 47 into the stack the new stack will be [76,47]

// 47 stack[76,47] - We will remove all element from stack which are equal or less than 47 so the stack is [76] and the result
// 3 and push 47 into the stack the new stack will be [76,47]

// 58 stack[76,47] - We will remove all element from stack which are equal or less than 47 so the stack is [76] and the result
// 4 and push 58 into the stack the new stack will be [76,58]