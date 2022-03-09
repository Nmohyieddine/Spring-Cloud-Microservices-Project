package com.microservices.billing;

import lombok.Data;

@Data
public class Product {

    public Long id;
    public String name;
    public double price;
}
