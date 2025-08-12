package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

class Cofee {
    private final String id;
    private String name;
    public Cofee(String name){
        this(UUID.randomUUID().toString(),name);
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
}
