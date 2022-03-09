package com.microservices.billing;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private String email;
}
