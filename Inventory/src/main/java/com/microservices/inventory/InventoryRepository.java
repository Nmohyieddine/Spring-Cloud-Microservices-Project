package com.microservices.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

}
