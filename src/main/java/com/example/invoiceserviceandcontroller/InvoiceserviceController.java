package com.example.invoiceserviceandcontroller;

import com.example.invoiceserviceandcontroller.model.Invoice;
import com.example.invoiceserviceandcontroller.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceserviceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices/{id}")
    Invoice one(@PathVariable Long id){
        return invoiceService.readInvoice(id);
    }

    @PostMapping("/invoices")
    Invoice newInvoice(@RequestBody Invoice newInvoice){
        return invoiceService.createInvoice(newInvoice);
    }
}
