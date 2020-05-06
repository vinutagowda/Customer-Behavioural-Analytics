package com.cts.cba.invoice.controller;

import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.service.InvoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/edit")
public class InvoiceController {

    @Autowired
    InvoiceService service;

    @RequestMapping(method = RequestMethod.POST, value = "/uploadinvoice")
    @ApiOperation(value = "Uploads invoices", notes = "Uploads invoices to database")
    void invoiceUpload(@RequestBody Invoice invoice) {
        service.addInvoice(invoice);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteinvoice/{invoiceId}")
    @ApiOperation(value = "Deletes invoices", notes = "Deletes invoices to database based on Invoice ID")
    void invoiceDelete(@PathVariable int invoiceId) {
        service.deleteInvoice(invoiceId);
    }

}