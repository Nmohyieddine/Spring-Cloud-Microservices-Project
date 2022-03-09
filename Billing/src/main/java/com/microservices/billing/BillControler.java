package com.microservices.billing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillControler {

    private BillingRepository billingRepository;
    private ProductItemRepository productItemRepository;

    private InventoryService inventoryService;
    private CustomerService customerService;

    public BillControler(BillingRepository billingRepository,
                         ProductItemRepository productItemRepository,
                         InventoryService inventoryService,
                         CustomerService customerService) {
        this.billingRepository = billingRepository;
        this.productItemRepository = productItemRepository;
        this.inventoryService = inventoryService;
        this.customerService = customerService;
    }
    @GetMapping("/Bill/{id}")
    public Bill GetBill(@PathVariable(name = "id") Long id){

        Bill bill=billingRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(inventoryService.getProdectById(productItem.getId()));
        });
        return bill;

    }


}
