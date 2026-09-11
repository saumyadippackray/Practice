package org.example.neetcode.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
            int[] nums=new int[]{1,1,1,3,3,2};
            TopKFrequentElements topKFrequentElements=new TopKFrequentElements();
            for(int i:topKFrequentElements.topKFrequent(nums,2))
                System.out.println(i);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] freq=new List[nums.length+1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int res[]=new int[k];
        int index=0;
        for(int i=freq.length-1;i>0 && k>index;i--){
            for(int j:freq[i]){
                res[index++]=j;
                if(index==k){
                    return res;
                }
//                index++;
            }
        }

        return null;
    }
}
