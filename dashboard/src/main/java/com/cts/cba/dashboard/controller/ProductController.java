package com.cts.cba.dashboard.controller;

import java.util.List;

import com.cts.cba.dashboard.entity.Product;
import com.cts.cba.dashboard.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    // @RequestMapping("/soldproductlist")
    // List<Product> getAllProduct() {
    // return (List<Product>) service.getAllProduct();
    // }

    @RequestMapping("/soldproductlist/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Gets list of discounted/non-discounted products", notes = "Generates list of discounted sales based on time interval, customer category")
    List<Product> getProductSold(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {
        return (List<Product>) service.getProductSold(timeDuration, customerCategory);
    }

    // @RequestMapping("/soldproductlist/{id}")
    // Optional<Product> getProductById(@PathVariable int id){
    // return service.getProductById(id);
    // }

    @RequestMapping("/soldproductlist/priceRange/{timeDuration}/{customerCategory}/{startPrice}/{endPrice}")
    @ApiOperation(value = "Gets list of products", notes = "Generates list of products and their sales details based on time interval, customer category, range of product price")
    List<Product> getAllProductByPriceRange(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Starting price of product", required = true) @PathVariable double startPrice,
            @ApiParam(value = "Ending price of product", required = true) @PathVariable double endPrice) {
        return (List<Product>) service.getAllProductByPriceRange(timeDuration, customerCategory, startPrice, endPrice);
    }

    @RequestMapping("/solddiscountlist/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Gets list of products", notes = "Generates list of products and their sales details based on time interval, customer category")
    List<Product> getAllProductByDiscount(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {
        return (List<Product>) service.getAllProductByDiscount(timeDuration, customerCategory);
    }

    @RequestMapping("/soldcategorylist/{timeDuration}/{customerCategory}/{category}")
    @ApiOperation(value = "Gets list of product categories", notes = "Generates list of categories of products with their average sales details")
    List<Product> getAllProductByCategory(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product category", required = true) @PathVariable String category) {
        return (List<Product>) service.getAllProductByCategory(timeDuration, customerCategory, category);
    }

    @RequestMapping("/soldbrandlist/{timeDuration}/{customerCategory}/{brand}")
    @ApiOperation(value = "Gets list of product brands", notes = "Generates list of brands with their average sales details")
    List<Product> getAllProductByBrand(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product brand", required = true) @PathVariable String brand) {
        return (List<Product>) service.getAllProductByBrand(timeDuration, customerCategory, brand);
    }

}