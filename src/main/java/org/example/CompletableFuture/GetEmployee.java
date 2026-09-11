package org.example.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GetEmployee {

    public static List<Employee> getEmployee(){
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            return objectMapper.readValue(new File("employee.json"),new TypeReference<List<Employee>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
