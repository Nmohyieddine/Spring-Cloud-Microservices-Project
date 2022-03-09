package com.microservices.billing;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name="fullBill",types = Bill.class)
public interface BillProjection {

    Long getId();
    Date getBillingDate();
    Long getCustomerId();
    Collection<ProductItem> getProductItems();
}
