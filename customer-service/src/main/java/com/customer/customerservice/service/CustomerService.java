package com.customer.customerservice.service;

import com.customer.customerservice.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> fetchAllCustomers();

    Customer createCustomer(Customer newCustomer);

    Customer getCustomerByEmail(String email);

    Optional<Customer> getCustomerById(Long id);

    Customer updateCustomer(Customer newCustomer, Long id);

    String deleteCustomer(Long id);
}
