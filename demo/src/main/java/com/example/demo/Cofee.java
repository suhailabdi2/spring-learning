package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatusCode;

import java.util.UUID;
@Entity
public class Cofee  {
    @Id
    private  String id;
    private String name;
    public Cofee(String name){
        this.id = java.util.UUID.randomUUID().toString();
        this.name = name;
        System.out.println("Cofee generation works");
    }
    @JsonCreator
    public Cofee(@JsonProperty("id")String id,@JsonProperty("name")String name ){
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }

}
