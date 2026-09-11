package org.example.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapPrint {
    public static void main(String[] args) {
        Map<String,Integer> employee=new HashMap<>();
        employee.put("suman",21);
        employee.put("tuki",19);
        Iterator<Map.Entry<String,Integer>> iterator=employee.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }
        for(String str:employee.keySet()){
            System.out.println(employee.get(str));
        }
    }
}
