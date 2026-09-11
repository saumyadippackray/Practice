package org.example.ComparatorExample;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        List<ComparatorExampleArrayList> comparatorExampleArrayListList=new ArrayList<>();
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(12,"suman"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(18,"tuki"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(13,"tuki"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(11,"tuki"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(20,"tuki"));
        System.out.println(comparatorExampleArrayListList);
        //Custom Sorting
//        Comparator comparator=new Comparator<ComparatorExampleArrayList>() {
//            @Override
//            public int compare(ComparatorExampleArrayList o1, ComparatorExampleArrayList o2) {
//               if(o1.age>o2.age)
//                   return 1;
//               else
//                   return -1;
//            }
//        };
//        Collections.sort(comparatorExampleArrayListList);
//        Collections.sort(comparatorExampleArrayListList,comparator);
        //Custom Sorting
        //System.out.println(comparatorExampleArrayListList);
        System.out.println("suman"+4+4);
        System.out.println(4+4+"suman");
        for(ComparatorExampleArrayList ca:comparatorExampleArrayListList){
            System.out.println(ca);
        }
        Optional<ComparatorExampleArrayList> comparatorExample=comparatorExampleArrayListList.stream().sorted(Comparator.comparingInt(ComparatorExampleArrayList::getAge).reversed()).skip(1).findFirst();
        System.out.println(comparatorExample.get());
    }
}
