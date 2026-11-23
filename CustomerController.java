package com.tracko.controller;

import com.tracko.entity.Customer;
import com.tracko.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    public String customers(@RequestParam(required = false) String search,
            Model model) {

        List<Customer> customers;

        if (search != null && !search.isBlank()) {
            customers = customerRepository.findByNameContainingIgnoreCase(search);
        } else {
            customers = customerRepository.findAll();
        }

        model.addAttribute("customers", customers);
        model.addAttribute("customer", new Customer());

        return "customers";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute Customer customer) {

        customerRepository.save(customer);

        return "redirect:/customers";
    }
}