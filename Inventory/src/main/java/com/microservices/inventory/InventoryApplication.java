package com.microservices.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {

            productRepository.save(new Product(null,"prod1",2000));
            productRepository.save(new Product(null,"prod2",2500));
            productRepository.save(new Product(null,"prod3",3000));
            productRepository.findAll().forEach(System.out::println);


        };
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer()
    {
        return RepositoryRestConfigurer.withConfig(config -> {
            config.exposeIdsFor(Product.class);
        });
    }

}
