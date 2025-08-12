package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class DemoApplication {
	public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}
    class Cofee {
        private final String id;
        private String name;
        public Cofee(String id,String name) {
            this.id = id;
            this.name= name;
        }
        public Cofee(String name){
            this(UUID.randomUUID().toString(),name);
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


}



