package com.cts.cba.invoice.service;

import java.util.List;

import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.repository.InvoiceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

        @Autowired
        InvoiceRepo repo;

        public void addInvoice(Invoice invoice) {
                repo.save(invoice);
        }

        public void deleteInvoice(int invoiceId) {
                repo.deleteById(invoiceId);
        }

        public List<Invoice> getAll() {
                return (List<Invoice>) repo.findAll();
        }
}