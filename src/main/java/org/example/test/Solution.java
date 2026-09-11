package org.example.test;

public class Solution {
    public static int solution(int[] A) {
        int value=0;
        // Implement your solution here
        for(int i=1;i<=A.length;i++){
            Boolean isNotExist=true;
            System.out.println("1"+i);
            for(int j=0;j<A.length;j++){
                if(A[j]==i){
                    isNotExist=false;
                }
            }
            System.out.println(isNotExist);
            if(isNotExist){
                value=i;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(Solution.solution(arr));
    }
}
