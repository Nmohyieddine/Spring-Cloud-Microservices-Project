package com.microservices.billing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients

public class BillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillingRepository billingRepository,
                            ProductItemRepository productItemRepository,
                            CustomerService customerService,
                            InventoryService inventoryService){
        return args -> {




            Customer customer =customerService.findCustomerById(1L);
            System.out.println("**********************");
                System.out.println(customer.getId());
                System.out.println(customer.getName());
                System.out.println(customer.getEmail());

            System.out.println("**********************");






            Bill bill= billingRepository.save(new Bill(null,new Date(),customer.getId(),null,null));
            inventoryService.getAllProduct().getContent().forEach(prod -> {
                productItemRepository.save(new ProductItem(null,prod.getId(),null,800,3,bill));

                System.out.println("**********************");
                System.out.println(prod.getId());
                System.out.println(prod.getName());
                System.out.println(prod.getPrice());

                System.out.println("**********************");
            });
        };
    }
}
