package com.cts.cba.product.repository;

import java.util.List;

import com.cts.cba.product.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory)))", nativeQuery = true)
    List<Product> findAllByDuration(int timeDuration, String customerCategory);

    @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory))) AND p.price BETWEEN :startPrice AND :endPrice ORDER BY p.price", nativeQuery = true)
    List<Product> findAllByPriceRange(int timeDuration, String customerCategory, double startPrice, double endPrice);

    @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory))) AND p.product_id IN(SELECT product_id FROM product_discount d WHERE d.discount_id<>1)", nativeQuery = true)
    List<Product> findAllByDiscount(int timeDuration, String customerCategory);

    @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory))) AND p.category=:category", nativeQuery = true)
    List<Product> findAllByCategory(int timeDuration, String customerCategory, String category);

    @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory))) AND p.brand=:brand", nativeQuery = true)
    List<Product> findAllByBrand(int timeDuration, String customerCategory, String brand);
}