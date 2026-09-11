package org.example.Serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.CompletableFuture.Employee;

import java.io.IOException;

public class Gsonexample {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"rollNo\":21,\"name\":\"Mahesh\"}";

        //create gson object
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        ////create gson object

        //
        ObjectMapper objectMapper=new ObjectMapper();
        //

        Student student=gson.fromJson(jsonString,Student.class);
        Student student1=objectMapper.readValue(jsonString,Student.class);
        System.out.println(student);
        System.out.println(student1);
        System.out.println(gson.toJson(student));
        System.out.println(objectMapper.writeValueAsString(student1));
    }
}
