package com.cts.cba.invoice;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.cba.invoice.entity.Customer;
import com.cts.cba.invoice.entity.Discount;
import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.entity.Product;
import com.cts.cba.invoice.model.InvoiceResponse;
import com.cts.cba.invoice.repository.InvoiceRepo;
import com.cts.cba.invoice.service.InvoiceService;
import com.google.common.collect.Lists;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceServiceTests {

    @Autowired
    private InvoiceService service;

    @MockBean
    private InvoiceRepo repo;

    @Test
    public void invoiceUploadTest() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Invoice invoice = new Invoice(257, formatter.format(currentDateTime), 26.1415, 548.9715, "Debitcard",
                Stream.of(new Product(11, "Watch", "Accessories", "Titan", "Average", 73.56, 10,
                        Sets.newSet(new Discount(1, "No Discount", "Zero perc discount", 0))))
                        .collect(Collectors.toList()),
                new Customer(107, "cat3", "Raghu", "Mysore"));
        when(repo.save(invoice)).thenReturn(invoice);
        assertEquals(invoice, repo.save(invoice));
    }

    @Test
    public void invoiceDeleteTest() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Invoice invoice = new Invoice(251, formatter.format(currentDateTime), 26.1415, 548.9715, "Debitcard",
                Stream.of(new Product(11, "Watch", "Accessories", "Titan", "Average", 73.56, 10,
                        Sets.newSet(new Discount(1, "No Discount", "Zero perc discount", 0))))
                        .collect(Collectors.toList()),
                new Customer(107, "cat3", "Raghu", "Mysore"));
        service.deleteInvoice(invoice.getInvoiceId());
        verify(repo,times(1)).deleteById(invoice.getInvoiceId());
    }
}