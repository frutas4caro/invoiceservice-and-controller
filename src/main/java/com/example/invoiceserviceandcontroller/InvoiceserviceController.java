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

    @PutMapping("/invoices/{id}")
    Invoice updateInvoice(@RequestBody Invoice existingInvoice, @PathVariable Long id) {
        return invoiceService.updateInvoice(existingInvoice, id); }

    @DeleteMapping("/invoices/{id}")
    void deleteInvoice(@PathVariable Long id) { invoiceService.deleteInvoice(id); }
}
