package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CoffeeRepository extends CrudRepository<Cofee, String>{
}
