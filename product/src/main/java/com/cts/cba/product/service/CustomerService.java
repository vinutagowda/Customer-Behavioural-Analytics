package com.cts.cba.product.service;

import java.util.List;

import com.cts.cba.product.entity.Product;
import com.cts.cba.product.repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo repo;

    public List<Product> getAllByLocation(int timeDuration, String customerCategory, String location) {
        return (List<Product>) repo.findAllByLocation(timeDuration, customerCategory, location);
    }

}