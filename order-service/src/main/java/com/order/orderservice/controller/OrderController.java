package com.order.orderservice.controller;

import com.order.orderservice.entities.Order;
import com.order.orderservice.model.Customer;
import com.order.orderservice.model.CustomerResponse;
import com.order.orderservice.service.CustomerService;
import com.order.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<String> postOrder(@RequestBody Order order){
        CustomerResponse customerResponse = customerService.getCustomer(order.getCustomerId());
        System.out.println(customerResponse.getIsError());
        System.out.println(customerResponse.getErrorMsg());
        if (customerResponse.getErrorMsg() != null &&
                customerResponse.getErrorMsg().contains("Not Found")) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(customerResponse.getErrorMsg());
        }
        else if(customerResponse.getErrorMsg()!=null && customerResponse.getErrorMsg().contains("Customer Service is Temporarily Unavailable")){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Customer Service is Temporarily Unavailable, Please Try Later");
        }

        return ResponseEntity.ok("Order Placed for customer: "+orderService.createOrder(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
