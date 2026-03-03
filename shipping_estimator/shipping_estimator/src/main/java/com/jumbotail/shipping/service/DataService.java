package com.jumbotail.shipping.service;

import com.jumbotail.shipping.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataService {

    private final List<Seller> sellers = Arrays.asList(
            new Seller(123, new Location(12.9716, 77.5946)), // Bangalore
            new Seller(124, new Location(19.0760, 72.8777))  // Mumbai
    );

    private final List<Customer> customers = Arrays.asList(
            new Customer(456, new Location(13.0827, 80.2707)), // Chennai
            new Customer(457, new Location(28.7041, 77.1025))  // Delhi
    );

    public Seller getSellerById(int id) {
        return sellers.stream()
                .filter(s -> s.getSellerId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Seller not found"));
    }

    public Customer getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}