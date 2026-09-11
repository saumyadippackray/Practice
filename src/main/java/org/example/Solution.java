//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//import java.util.stream.Collectors;
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class Solution {
//
//    public static void main(String[] args) {
//        List<Item> items = Arrays.asList(
//                new Item("apple", 10, new BigDecimal("9.99")),
//                new Item("banana", 20, new BigDecimal("19.99")),
//                new Item("orang", 10, new BigDecimal("29.99")),
//                new Item("watermelon", 10, new BigDecimal("29.99")),
//                new Item("papaya", 20, new BigDecimal("9.99")),
//                new Item("apple", 10, new BigDecimal("9.99")),
//                new Item("banana", 10, new BigDecimal("19.99")),
//                new Item("apple", 20, new BigDecimal("9.99"))
//        );
//
//        List<Integer> integerList= Arrays.asList(1,10,15);
//
//        integerList.stream().filter(a-> a>10).filter(b->b%10==0).findFirst().get();
//
//
//
//        //Question 1 - Group by Item name and display count
//        // Example - papaya=1, banana=2, apple=3, orang=1, watermelon=1
//
//        Map<String ,Integer> fruitsCount=new HashMap<>();
//        for(Item item:items){
//            if(Objects.isNull(fruitsCount.get(item.getName()))){
//                fruitsCount.put(item.getName(),item.getQty());
//            }
//            else{
//                fruitsCount.put(item.getName(), fruitsCount.get(item.getName())+item.getQty());
//            }
//        }
//
//        for (String key:fruitsCount.keySet()){
//            System.out.print(key+"="+fruitsCount.get(key));
//        }
//
//        //Question 2 - Group by Item name and show total Qty
//        // Example - papaya=20, banana=30, apple=40, orang=10, watermelon=10
//
//
//    }
//
//}
//
//class Item {
//
//    private String name;
//    private int qty;
//    private BigDecimal price;
//
//    public Item(String name, int qty, BigDecimal price) {
//        this.name = name;
//        this.qty = qty;
//        this.price = price;
//    }
//    public String getName(){
//        return name;
//    }
//    public int getQty(){
//        return qty;
//    }
//    public BigDecimal getPrice(){
//        return price;
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//Employee-
//emp_id
//emp_name
//dept_name
//supervisor_id
//        emp_id     emp_id
//        1           2
//
////saumyadip   sup_name
//select a.emp_name,b.emp_name from employee a join employee b on a.supervisor_id=b.emp_id;
//select dept_name,count(dept_name) from employee group by dept_name having count(dept_name)>1000;