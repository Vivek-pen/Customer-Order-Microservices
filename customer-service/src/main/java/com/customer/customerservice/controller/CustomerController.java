package com.customer.customerservice.controller;

import com.customer.customerservice.entity.Customer;
import com.customer.customerservice.repository.CustomerRepository;
import com.customer.customerservice.service.CustomerService;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DefaultEditorKit;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> fetchAllCustomers(){
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return ResponseEntity.ok(customerService.updateCustomer(customer,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> GetCustomerById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}

