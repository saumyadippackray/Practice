package org.example.neetcode.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElementUsingBucketSort {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> numCount=new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        int[] result=new int[2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(int num:nums)
        {
            numCount.put(num,numCount.getOrDefault(numCount,0)+1);
        }


        for(Map.Entry<Integer, Integer> entry : numCount.entrySet()){
           freq[entry.getValue()].add(entry.getKey());
        }

        for(int i=nums.length-1;i>0 && index<k;i++){
            for (int n:freq[i]){
               result[index++]=n;
               if(index==k)
                   return result;
            }


        }
        return null;
    }
}


//[1,1,1,2,2,100]
//     1    2   3  4  5  6  ---Will take a array of size of array+1 and add the element according to there occurance if the 1 occur 3 times then we will put 1 to index 3
//   [100] [2] [1]