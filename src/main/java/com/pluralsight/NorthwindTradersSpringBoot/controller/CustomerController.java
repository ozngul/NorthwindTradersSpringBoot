package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CustomerDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerDAO.getAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerDAO.add(customer);
    }
}
