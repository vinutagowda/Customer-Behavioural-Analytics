package com.cts.cba.product.repository;

import java.util.List;

import com.cts.cba.product.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Product, Integer> {

   @Query(value = "SELECT * FROM product p WHERE p.product_id IN(SELECT product_id FROM invoice_product i WHERE i.invoice_id IN(SELECT invoice_id FROM invoice j WHERE j.invoice_date>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.customer_id IN(SELECT customer_id FROM customer c WHERE c.customer_category=:customerCategory AND c.location=:location)))", nativeQuery = true)
   List<Product> findAllByLocation(int timeDuration, String customerCategory, String location);

}