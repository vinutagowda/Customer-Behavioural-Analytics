package com.cts.cba.dashboard.repository;

import java.util.List;

import com.cts.cba.dashboard.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Product, Integer> {

   @Query(value = "SELECT * FROM product p WHERE p.pid IN(SELECT pid FROM invoice_product i WHERE i.iid IN(SELECT iid FROM invoice j WHERE j.idate>=DATE_SUB(CURDATE(), INTERVAL :timeDuration MONTH) AND j.cid IN(SELECT cid FROM customer c WHERE c.cat=:customerCategory AND c.location=:location)))", nativeQuery = true)
   List<Product> findAllByLocation(int timeDuration, String customerCategory, String location);

}