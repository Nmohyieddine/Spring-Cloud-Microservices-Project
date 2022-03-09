package com.microservices.custumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumerApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {

            customerRepository.save(new Customer(null,"mohyi eddine","mohyi.nahi@gmail.com"));
            customerRepository.save(new Customer(null,"Saad","saadmacbook@gmail.com"));
            customerRepository.save(new Customer(null,"khalileljoulali","khalileljoulali@gmail.com"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
