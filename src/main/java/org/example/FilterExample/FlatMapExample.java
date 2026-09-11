package org.example.FilterExample;

import org.example.CompletableFuture.Employee;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<EmployeeWithListOfCity> employee=new ArrayList<>();
        String cityList1[]={"Pune","Bengalore"};
        String cityList2[]={"Pune","Bengalore","Kolkata"};
        employee.add(new EmployeeWithListOfCity(1,"suman", Arrays.asList(cityList1)));
        employee.add(new EmployeeWithListOfCity(1,"suman1", Arrays.asList(cityList2)));

        Set<String> cities=employee.stream().flatMap(emp->emp.getCity().stream()).collect(Collectors.toSet());
        System.out.println(cities);
    }
}
