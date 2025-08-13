package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    @Autowired
    private final CoffeeRepository cofeeRepository;
    public RestApiDemoController(CoffeeRepository cofeeRepository){
        this.cofeeRepository = cofeeRepository;
        System.out.println("Worked here");
    }
    // populate the table
    @PostConstruct
    public void initData(){
        cofeeRepository.saveAll(List.of(
                new Cofee("Arabica"),
                new Cofee("Indica")
        ));
    }
    @GetMapping("/coffees")
    Iterable<Cofee> getCofees(){
        return cofeeRepository.findAll();
    }
    @GetMapping("/cofee/{id}")
    Optional<Cofee> getCofee(@PathVariable String id){
        return cofeeRepository.findById(id);
    }
    @PostMapping("/coffi")
    Cofee postCoffee(@RequestBody Cofee cofee){
        cofeeRepository.save(cofee);
        return cofee;
    }
    @PutMapping("/coffees/{id}")
    ResponseEntity<Cofee> putCoffee(@PathVariable String id, @RequestBody Cofee cofee){
        return !cofeeRepository.existsById(id)
                ? new ResponseEntity<>(cofeeRepository.save(cofee), HttpStatus.CREATED)
                : new ResponseEntity<>(cofeeRepository.save(cofee), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    void deleteCofee(@PathVariable String id){
        cofeeRepository.deleteById(id);
    }

}
