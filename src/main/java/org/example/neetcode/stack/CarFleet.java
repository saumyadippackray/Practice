package org.example.neetcode.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        System.out.println(CarFleet.carFleet(10, new int[]{6,8},new int[]{3,2}));
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][] carpair=new int[n][2];
        Stack<Double> carStack=new Stack<>();
        for(int i=0;i<n;i++){
            carpair[i][0]=position[i];
            carpair[i][1]=speed[i];
        }
        Arrays.sort(carpair,(a, b)->Integer.compare(b[0],a[0]));

        for (int i=0;i<n;i++){

            if(carStack.isEmpty()){
                carStack.push((double)(target-carpair[i][0])/carpair[i][1]);
            }
            else{
                double topValue=carStack.peek();
                carStack.push((double)(target-carpair[i][0])/carpair[i][1]);
                if(carStack.peek()<=topValue)
                    carStack.pop();
            }

        }
        return carStack.size();
    }
}

//target=12
//        position=[10,8,0,5,3]
//        speed=[2,4,1,1,3]
// 1 1 7 3 12
//target = 10, position = [4,1,0,7], speed = [2,2,1,1]
// We will combined these two array and sort by position so the sorted combined array looked like
//[[0,1],[1,2],[4,2],[7,1]]
//We will take a stack will push the position int in the stack and compare if the top element of the stack is taking how much time if the time is greater or equal the
//new element then we will remove the new element from the stack so for 4 the time taking to react 10 is 10-4/2=3 and position 7 will take 10-7/1=3 so we will remove
//position 7 because both will reach same time.
// Now for 1 it will take 10-1/2=4.5 with is greater than the top element 3 so we will not remove that
// Now for 0 it will take 10-0/2=5 with is greater than the top element 4.5 so we will not remove that