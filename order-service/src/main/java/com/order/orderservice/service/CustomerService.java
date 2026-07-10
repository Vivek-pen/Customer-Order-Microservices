package com.order.orderservice.service;

import com.order.orderservice.client.CustomerClient;
import com.order.orderservice.exception.CustomerNotFoundException;
import com.order.orderservice.model.Customer;
import com.order.orderservice.model.CustomerResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerClient customerClient;

    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "fallbackGetCustomer")
    public CustomerResponse getCustomer(Long id){
        CustomerResponse customerResponse = new CustomerResponse();
        Customer customer = customerClient.getCustomerById(id);
        if(customer!=null){
            customerResponse.setCustomer(customer);
            customerResponse.setIsError(false);
        }
        return customerResponse;
    }

    public CustomerResponse fallbackGetCustomer(Long id, Throwable t){
        System.out.println(t.getClass());
        System.out.println(t.getMessage());

        CustomerResponse response  = new CustomerResponse();
        if(t instanceof CustomerNotFoundException){
            response.setIsError(true);
            response.setErrorMsg(t.getMessage());
        }
        else{
            response.setIsError(true);
            response.setErrorMsg("Customer Service is Temporarily Unavailable");
        }
        return response;
    }
}
