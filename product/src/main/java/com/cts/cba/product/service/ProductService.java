package com.cts.cba.product.service;

import java.util.List;
import java.util.Optional;

import com.cts.cba.product.entity.Product;
import com.cts.cba.product.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> getProductSold(int timeDuration, String customerCategory) {
        return (List<Product>) repo.findAllByDuration(timeDuration, customerCategory);
    }

    // public List<Product> getAllProduct() {
    // return (List<Product>) repo.findAll();
    // }

    // public Optional<Product> getProductById(int id) {
    // return repo.findById(id);
    // }

    public List<Product> getAllProductByPriceRange(int timeDuration, String customerCategory, double startPrice, double endPrice) {
        return (List<Product>) repo.findAllByPriceRange(timeDuration, customerCategory, startPrice, endPrice);
    }

    public List<Product> getAllProductByDiscount(int timeDuration, String customerCategory) {
        return (List<Product>) repo.findAllByDiscount(timeDuration, customerCategory);
    }

    public List<Product> getAllProductByCategory(int timeDuration, String customerCategory, String category) {
		return (List<Product>) repo.findAllByCategory(timeDuration, customerCategory, category);
	}

	public List<Product> getAllProductByBrand(int timeDuration, String customerCategory, String brand) {
		return (List<Product>) repo.findAllByBrand(timeDuration, customerCategory, brand);
	}

}