package com.cts.cba.invoice.controller;

import java.util.HashMap;
import java.util.Map;

import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.service.InvoiceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Invoice", description = "A controller to activate endpoints related to properties of invoice entity")
@RequestMapping("/edit")
@RefreshScope
public class InvoiceController {

    Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    InvoiceService service;

    @RequestMapping(method = RequestMethod.POST, value = "/uploadinvoice")
    @ApiOperation(value = "Uploads invoices", notes = "Uploads invoices to database")
    public void invoiceUpload(@ApiParam(value = "Entire invoice", required = true) @RequestBody Invoice invoice) {

        logger.debug("Resquest: Invoice");
        if (invoice.equals(null)) {
            throw new RuntimeException("Upload Failed !");
        } else {
            logger.info("Response: Successfully Uploaded");
        }

        service.addInvoice(invoice);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteinvoice/{invoiceId}")
    @ApiOperation(value = "Deletes invoices", notes = "Deletes invoices to database based on Invoice ID")
    public void invoiceDelete(@ApiParam(value = "Invoice ID to be deleted", required = true) @PathVariable int invoiceId) {
        
        logger.debug("Resquest: Delete {}", invoiceId);
        Map<Integer, Invoice> map=new HashMap<>();
        if (!map.containsKey(invoiceId)) {
            throw new RuntimeException("Delete Failed !");
        } else {
            logger.info("Response: Successfully Deleted");
        }
        service.deleteInvoice(invoiceId);
    }

}