package com.microservices.billing;

import lombok.extern.slf4j.Slf4j;
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
    CommandLineRunner start(BillingRepository billingRepository,ProductRepository productRepository,CustomerService customerService){
        return args -> {



            Bill bill= billingRepository.save(new Bill(null,new Date(),1L,null));
            productRepository.save(new ProductItem(null,1L,800,3,bill));
            productRepository.save(new ProductItem(null,2L,1000,1,bill));

            Customer customer =customerService.findCustomerById(1L);
            System.out.println("**********************");
                System.out.println(customer.getId());
                System.out.println(customer.getName());
                System.out.println(customer.getEmail());

            System.out.println("**********************");
        };
    }
}
