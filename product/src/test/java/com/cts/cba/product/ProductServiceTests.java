package com.cts.cba.product;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.cba.product.entity.Discount;
import com.cts.cba.product.entity.Product;
import com.cts.cba.product.repository.ProductRepo;
import com.cts.cba.product.service.ProductService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService service;

    @MockBean
    private ProductRepo repo;

    @Test
    public void getProductSoldTest() {
        int timeDuration = 14;
        String customerCategory = "cat1";
        when(repo.findAllByDuration(timeDuration, customerCategory)).thenReturn(Stream
                .of(new Product(1176, "Sugar", "Food & Beverages", "NSF", "Good", 74.69, 50, new HashSet<Discount>()))
                .collect(Collectors.toList()));
        assertEquals(1, service.getProductSold(timeDuration, customerCategory).size());
    }

    @Test
    public void getAllProductByPriceRangeTest() {
        int timeDuration = 15;
        String customerCategory = "cat2";
        double startPrice = 50;
        double endPrice = 200;
        when(repo.findAllByPriceRange(timeDuration, customerCategory, startPrice, endPrice))
                .thenReturn(Stream.of(new Product(1125, "pen", "Home & LifeStyle", "Pavithra brite", "Average", 72.61,
                        5, new HashSet<Discount>())).collect(Collectors.toList()));
        assertEquals(1, service.getAllProductByPriceRange(timeDuration, customerCategory, startPrice, endPrice).size());
    }

    @Test
    public void getAllProductByDiscountTest() {
        int timeDuration = 20;
        String customerCategory = "cat3";
        when(repo.findAllByDiscount(timeDuration, customerCategory)).thenReturn(Stream
                .of(new Product(1117, "Watch", "Accessories", "Titan", "Average", 73.56, 10, new HashSet<Discount>()))
                .collect(Collectors.toList()));
        assertEquals(1, service.getAllProductByDiscount(timeDuration, customerCategory).size());
    }

    @Test
    public void getAllProductByCategoryTest() {
        int timeDuration = 14;
        String customerCategory = "cat4";
        String category = "Food & Beverages";
        when(repo.findAllByCategory(timeDuration, customerCategory, category))
                .thenReturn(Stream.of(new Product(1123, "Coffee Powder", "Food & Beverages", "Cothas", "Average", 93.72,
                        5, new HashSet<Discount>())).collect(Collectors.toList()));
        assertEquals(1, service.getAllProductByCategory(timeDuration, customerCategory, category).size());
    }

    @Test
    public void getAllProductByBrandTest() {
        int timeDuration = 16;
        String customerCategory = "cat1";
        String brand = "Nescafe";
        when(repo.findAllByBrand(timeDuration, customerCategory, brand))
                .thenReturn(Stream.of(new Product(1111, "Coffee powder", "Food & Beverages", "Nescafe", "Good", 74.69,
                        50, new HashSet<Discount>())).collect(Collectors.toList()));
        assertEquals(1, service.getAllProductByBrand(timeDuration, customerCategory, brand).size());
    }
}