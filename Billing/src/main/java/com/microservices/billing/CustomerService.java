package com.microservices.billing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CONSUMER-SERVICE")
public interface CustomerService {

    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable(name = "id") Long id);

    @GetMapping("/customers")
    PagedModel<Customer> findAllCustomer();

}