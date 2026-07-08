package com.customer.customerservice.repository;

import com.customer.customerservice.entity.Customer;
import com.customer.customerservice.exception.CustomerNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getCustomersByEmail(String email);
}
