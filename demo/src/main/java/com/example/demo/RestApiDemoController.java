package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private List<Cofee> coffees = new ArrayList<>();
    public RestApiDemoController(){
        coffees.addAll(List.of(
                new Cofee("Arabica"),
                new Cofee("Robusta"),
                new Cofee("Mexicana")
        ));
    }
    @GetMapping("/coffees")
    Iterable<Cofee> getCofees(){
        return coffees;
    }
    @GetMapping("/cofee/{id}")
    Optional<Cofee> getCofee(@PathVariable String id){
        for (Cofee c : coffees) {
            if (c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }
    @PostMapping("/coffi")
    Cofee postCoffee(@RequestBody Cofee cofee){
        coffees.add(cofee);
        return cofee;
    }
    @PutMapping("/coffees/{id}")
    Cofee putCoffee(@PathVariable String id, @RequestBody Cofee cofee){
        int coffeeIndex= -1;
        for (Cofee c: coffees){
            if(c.getId().equals(id)){
                coffeeIndex= coffees.indexOf(c);
                coffees.set(coffeeIndex,cofee);
            }
        }
        return (coffeeIndex == -1)? postCoffee(cofee): cofee;
    }
    @DeleteMapping("/{id}")
    void deleteCofee(@PathVariable String id){
        coffees.removeIf(c-> c.getId().equals(id));
    }
}
