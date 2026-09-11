package org.example.FilterExample;


import org.example.ComparatorExample.ComparatorExampleArrayList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExample {
    public static void main(String[] args) {
        List<ComparatorExampleArrayList> comparatorExampleArrayListList=new ArrayList<>();
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(12,"suman"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(18,"tuki"));
        comparatorExampleArrayListList.add(new ComparatorExampleArrayList(13,"tuki"));
        //System.out.println(comparatorExampleArrayListList);
        comparatorExampleArrayListList.forEach(n->System.out.println(n));
        List<Integer> intArray= Arrays.asList(1,2,3,4,5,6,8,10,12);
        Stream<Integer> stream=intArray.stream().map(n->n*2);//map
        stream.forEach(n -> System.out.println(n));//foreach
//        System.out.println("result"+intArray.stream().filter(n->n%2==0).
//                map(n->2*n).
//                reduce(0,(c,e)->c+e));//o is the initial value in reduce
        List<ComparatorExampleArrayList> newListWithAllTuki=comparatorExampleArrayListList.
                parallelStream().filter(student->"tuki".equals(student.getName())).collect(Collectors.toList());//filter
        ComparatorExampleArrayList newListWithAnyTuki=comparatorExampleArrayListList.
                stream().filter(student->"tuki".equals(student.getName())).findAny().orElse(null);//filter
        newListWithAllTuki.stream().forEach(tuki->System.out.println(tuki));

        int i=intArray.stream().filter(num->num%2==0).map(finalNum->finalNum*2).reduce(0,(a,b)->a+b);
        System.out.println(i);
        List<Integer> sorted=intArray.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);

        int additionOfSqureValue=intArray.stream().filter(ii->ii%2==0).map(a->a*a).reduce(0,(a,b)->a+b);
        System.out.println("additionOfSqureValue"+additionOfSqureValue);

        Optional<ComparatorExampleArrayList> comparatorExampleArrayListWithOldest=comparatorExampleArrayListList.stream().collect(Collectors.maxBy(Comparator.comparing(ComparatorExampleArrayList::getAge)));
        System.out.println(comparatorExampleArrayListWithOldest.get());

        Optional<ComparatorExampleArrayList> comparatorExampleArrayListWithYoungest=comparatorExampleArrayListList.stream().collect(Collectors.minBy(Comparator.comparing(ComparatorExampleArrayList::getAge)));
        System.out.println(comparatorExampleArrayListWithYoungest.get());
    }

}
