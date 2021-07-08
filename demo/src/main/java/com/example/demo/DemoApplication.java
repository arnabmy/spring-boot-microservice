package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		repository.deleteAll();

		//save a couple of customers
		repository.save(new Customer("Arnab", "Mohanty"));
		repository.save(new Customer("Rachit ", "Gupta"));

		//fetch all customers 
		System.out.println("Customers found with findAll....");

		for(Customer customer : repository.findAll()){
			System.out.println("customer .."+customer);
		}

		//Fetch individual customers
		System.out.println("Customer found with findByFirstName('Arnab'):");
   	    System.out.println("--------------------------------");
		System.out.print(repository.findByFirstName("Arnab"));

	}




}
