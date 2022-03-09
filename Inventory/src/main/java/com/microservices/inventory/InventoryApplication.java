package com.microservices.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InventoryRepository inventoryRepository){
        return args -> {

            inventoryRepository.save(new Inventory(null,"prod1",2000));
            inventoryRepository.save(new Inventory(null,"prod2",2500));
            inventoryRepository.save(new Inventory(null,"prod3",3000));
            inventoryRepository.findAll().forEach(System.out::println);


        };
    }

}
