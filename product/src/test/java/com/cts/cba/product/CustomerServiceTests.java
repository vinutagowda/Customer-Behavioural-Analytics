package com.cts.cba.product;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.cba.product.entity.Discount;
import com.cts.cba.product.entity.Product;
import com.cts.cba.product.repository.CustomerRepo;
import com.cts.cba.product.service.CustomerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    private CustomerService service;

    @MockBean
    private CustomerRepo repo;

    @Test
    public void getAllByLocationTest() {
        int timeDuration = 16;
        String customerCategory = "cat1";
        String location = "Banglore";
        when(repo.findAllByLocation(timeDuration, customerCategory, location)).thenReturn(Stream.of(new Product(1111,"Coffee powder",
        "Food & Beverages","Nescafe","Good",74.69,50, new HashSet<Discount>())).collect(Collectors.toList()));
        assertEquals(1, service.getAllByLocation(timeDuration, customerCategory, location).size());
    }
}