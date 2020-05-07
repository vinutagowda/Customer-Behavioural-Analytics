package com.cts.cba.invoice.controller;

import com.cts.cba.invoice.entity.Invoice;
import com.cts.cba.invoice.service.InvoiceService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @Autowired
    InvoiceService service;
    private  Logger logger = LogManager.getLogger(InvoiceController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/uploadinvoice")
    @ApiOperation(value = "Uploads invoices", notes = "Uploads invoices to database")
    void invoiceUpload(@ApiParam(value = "Entire invoice", required = true) @RequestBody Invoice invoice) {
        logger.info("uploadeded invoice successfully");

        service.addInvoice(invoice);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteinvoice/{invoiceId}")
    @ApiOperation(value = "Deletes invoices", notes = "Deletes invoices to database based on Invoice ID")
    void invoiceDelete(@ApiParam(value = "Invoice ID to be deleted", required = true) @PathVariable int invoiceId) {
        logger.info("invoice was deleted successfully");
        service.deleteInvoice(invoiceId);
    }

}