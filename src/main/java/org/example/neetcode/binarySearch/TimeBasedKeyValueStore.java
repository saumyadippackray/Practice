package org.example.neetcode.binarySearch;

import java.util.*;

public class TimeBasedKeyValueStore {
    Map<String, List<Pair<Integer,String>>> timeBasedKeyValueMap;
    public TimeBasedKeyValueStore() {
        timeBasedKeyValueMap=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeBasedKeyValueMap.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair<>(timestamp,value));
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values=timeBasedKeyValueMap.get(key);
        if(Objects.isNull(values))
            return "";
        int start=0;
        int end= values.size()-1;
        String result="";

        while (start<=end){
            int mid=(start+end)/2;

            if (values.get(mid).getKey()<=timestamp) {
                result=values.get(mid).getValue();//If the values is greater than the mid in the case the value will be mid because we want the less than the target value
                start=mid+1;
            }
            else {
                end=mid-1;
            }

        }
        return result;
    }
//["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], "set", ["alice", "sad", 3], "get", ["alice", 3]]
    //[null, null, "happy", "happy", null, "sad"]
    class Pair<K,V>{
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
