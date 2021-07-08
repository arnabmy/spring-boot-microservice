package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
	private CustomerRepository repository;

    @RequestMapping("/")
    public String index(){
        return "Greetings !!";
    }

    //sample end point - http://localhost:8080/findCustomer?name=Arnab
    @RequestMapping("/findCustomer")
    public String findCustomer(@RequestParam(value = "name")String name){
        return "Greetings !!   "+repository.findByFirstName(name);
    }

    // End point - http://localhost:8080/hello?name=Arnab
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


    
}
