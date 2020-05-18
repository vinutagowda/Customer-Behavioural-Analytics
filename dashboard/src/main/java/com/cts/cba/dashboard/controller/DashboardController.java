package com.cts.cba.dashboard.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.cts.cba.dashboard.model.Discount;
import com.cts.cba.dashboard.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Dashboard", description = "A controller to consume product services endpoints")
@RequestMapping("/dashb")
@RefreshScope
public class DashboardController {

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(DashboardController.class);

    public String baseUrl = "http://localhost:8083/customers";
    public String baseUrl1 = "http://localhost:8083/products";

    @RequestMapping(method = RequestMethod.GET, value = "/locationsales/{timeDuration}/{customerCategory}/{location}")
    @ApiOperation(value = "Consumes list of locations endpoint", notes = "Consumes endpoint generating list of location based product sales")
    @HystrixCommand(fallbackMethod = "getFallbackAllByLocation", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getAllByLocation(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Location of customers", required = true) @PathVariable String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                this.baseUrl + "/soldlocationlist/" + timeDuration + "/" + customerCategory + "/" + location,
                HttpMethod.GET, requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution..!");
        } else {
            logger.info("Response: Successfully Executed..!");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsales/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Consumes list of products endpoint", notes = "Consumes endpoint generating list of products and their sales details based on time interval, customer category")
    @HystrixCommand(fallbackMethod = "getFallbackProductSold", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getProductSold(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                this.baseUrl1 + "/soldproductlist/" + timeDuration + "/" + customerCategory, HttpMethod.GET,
                requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution ");
        } else {
            logger.info("Response: Successfully Executed ");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsales/{timeDuration}/{customerCategory}/{startPrice}/{endPrice}")
    @ApiOperation(value = "Consumes price-range based list of products endpoint", notes = "Consumes endpoint generating list of products and their sales details based on time interval, customer category, range of product price")
    @HystrixCommand(fallbackMethod = "getFallbackAllProductByPriceRange", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getAllProductByPriceRange(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Starting price of product", required = true) @PathVariable double startPrice,
            @ApiParam(value = "Ending price of product", required = true) @PathVariable double endPrice) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(this.baseUrl1 + "/soldproductlist/priceRange/"
                + timeDuration + "/" + customerCategory + "/" + startPrice + "/" + endPrice, HttpMethod.GET,
                requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution.");
        } else {
            logger.info("Response: Successfully Executed.");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsales/discount/{timeDuration}/{customerCategory}")
    @ApiOperation(value = "Gets list of discounted/non-discounted products", notes = "Generates list of discounted sales based on time interval, customer category")
    @HystrixCommand(fallbackMethod = "getFallbackAllProductByDiscount", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getAllProductByDiscount(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                this.baseUrl1 + "/solddiscountlist/" + timeDuration + "/" + customerCategory, HttpMethod.GET,
                requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution...");
        } else {
            logger.info("Response: Successfully Executed...");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsales/category/{timeDuration}/{customerCategory}/{category}")
    @ApiOperation(value = "Gets list of product categories", notes = "Generates list of categories of products with their average sales details")
    @HystrixCommand(fallbackMethod = "getFallbackAllProductByCategory", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getAllProductByCategory(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product category", required = true) @PathVariable String category) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                this.baseUrl1 + "/soldcategorylist/" + timeDuration + "/" + customerCategory + "/" + category,
                HttpMethod.GET, requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productsales/brand/{timeDuration}/{customerCategory}/{brand}")
    @ApiOperation(value = "Gets list of product brands", notes = "Generates list of brands with their average sales details")
    @HystrixCommand(fallbackMethod = "getFallbackAllProductByBrand", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000") })
    public List<Object> getAllProductByBrand(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product brand", required = true) @PathVariable String brand) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Object[]> responseEntity = restTemplate.exchange(
                this.baseUrl1 + "/soldbrandlist/" + timeDuration + "/" + customerCategory + "/" + brand, HttpMethod.GET,
                requestEntity, Object[].class);
        if (responseEntity.getBody() == null) {
            throw new RuntimeException("Failed Execution !");
        } else {
            logger.info("Response: Successfully Executed");
        }
        return Arrays.asList(responseEntity.getBody());
    }

    public List<Object> getFallbackAllByLocation(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Location of customers", required = true) @PathVariable String location) {
        return Arrays.asList(new Product(0, "No Product Found", "", "", "", 0, 0, new HashSet<Discount>()));
    }

    public List<Object> getFallbackProductSold(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {
        return Arrays.asList(new Product(00, "No Products", "", "", "", 0, 0, new HashSet<Discount>()));
    }

    public List<Object> getFallbackAllProductByPriceRange(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Starting price of product", required = true) @PathVariable double startPrice,
            @ApiParam(value = "Ending price of product", required = true) @PathVariable double endPrice) {
        return Arrays.asList(new Product(000, "No Such Product", "", "", "", 0, 0, new HashSet<Discount>()));
    }

    public List<Object> getFallbackAllProductByDiscount(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory) {
        return Arrays.asList(new Product(0000, "Nil Product", "", "", "", 0, 0, new HashSet<Discount>()));
    }

    public List<Object> getFallbackAllProductByCategory(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product category", required = true) @PathVariable String category) {
        return Arrays.asList(new Product(00000, "No Product", category, "", "", 0, 0, new HashSet<Discount>()));
    }

    public List<Object> getFallbackAllProductByBrand(
            @ApiParam(value = "Time duration in months", required = true) @PathVariable int timeDuration,
            @ApiParam(value = "Category of customers", required = true) @PathVariable String customerCategory,
            @ApiParam(value = "Product brand", required = true) @PathVariable String brand) {
        return Arrays.asList(new Product(000000, "No Product", "", brand, "", 0, 0, new HashSet<Discount>()));
    }
}