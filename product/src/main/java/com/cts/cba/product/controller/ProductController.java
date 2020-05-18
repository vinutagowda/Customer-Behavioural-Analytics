package com.cts.cba.product.controller;

import java.util.List;

import com.cts.cba.product.entity.Product;
import com.cts.cba.product.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Product", description = "A controller to activate endpoints related to properties of product entity")
@RequestMapping("/products")
@RefreshScope
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    // @RequestMapping("/soldproductlist")
    // List<Product> getAllProduct() {
    // return (List<Product>) service.getAllProduct();
    // }

    @RequestMapping(method = RequestMethod.GET, value = "/soldproductlist/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Gets list of products", notes = "Generates list of products and their sales details based on time interval, customer category")
    public List<Product> getProductSold(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {

        logger.debug("Resquest: {} | {}", timeDuration, customerCategory);
        List<Product> list = service.getProductSold(timeDuration, customerCategory);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution..!");
        } else {
            logger.info("Response: Successfully Executed..");
        }

        return list;
    }

    // @RequestMapping("/soldproductlist/{id}")
    // Optional<Product> getProductById(@PathVariable int id){
    // return service.getProductById(id);
    // }

    @RequestMapping(method = RequestMethod.GET, value = "/soldproductlist/priceRange/{timeDuration}/{customerCategory}/{startPrice}/{endPrice}")
    @ApiOperation(value = "Gets list of products", notes = "Generates list of products and their sales details based on time interval, customer category, range of product price")
    public List<Product> getAllProductByPriceRange(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Starting price of product", required = true) @PathVariable double startPrice,
            @ApiParam(value = "Ending price of product", required = true) @PathVariable double endPrice) {

        logger.debug("Resquest: {} | {} | {} | {}", timeDuration, customerCategory, startPrice, endPrice);
        List<Product> list = service.getAllProductByPriceRange(timeDuration, customerCategory, startPrice, endPrice);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution!");
        } else {
            logger.info("Response: Successfully Executed!");
        }

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/solddiscountlist/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Gets list of discounted/non-discounted products", notes = "Generates list of discounted sales based on time interval, customer category")
    public List<Product> getAllProductByDiscount(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {

        logger.debug("Resquest: {} | {}", timeDuration, customerCategory);
        List<Product> list = service.getAllProductByDiscount(timeDuration, customerCategory);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution..");
        } else {
            logger.info("Response: Successfully Executed...");
        }

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/soldcategorylist/{timeDuration}/{customerCategory}/{category}")
    @ApiOperation(value = "Gets list of product categories", notes = "Generates list of categories of products with their average sales details")
    public List<Product> getAllProductByCategory(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product category", required = true) @PathVariable String category) {

        logger.debug("Resquest: {} | {} | {}", timeDuration, customerCategory, category);
        List<Product> list = service.getAllProductByCategory(timeDuration, customerCategory, category);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/soldbrandlist/{timeDuration}/{customerCategory}/{brand}")
    @ApiOperation(value = "Gets list of product brands", notes = "Generates list of brands with their average sales details")
    public List<Product> getAllProductByBrand(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product brand", required = true) @PathVariable String brand) {

        logger.debug("Resquest: {} | {} | {}", timeDuration, customerCategory, brand);
        List<Product> list = service.getAllProductByBrand(timeDuration, customerCategory, brand);
        if (list.isEmpty()) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }

        return list;
    }

}