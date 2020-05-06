package com.cts.cba.invoice.repository;

import com.cts.cba.invoice.entity.Invoice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends CrudRepository<Invoice,Integer>{
    
}