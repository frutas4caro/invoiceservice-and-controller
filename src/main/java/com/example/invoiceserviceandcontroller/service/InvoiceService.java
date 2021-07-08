package com.example.invoiceserviceandcontroller.service;

import com.example.invoiceserviceandcontroller.model.Invoice;
import com.example.invoiceserviceandcontroller.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Create an invoice

    public Invoice createInvoice(Invoice newInvoice){
        return invoiceRepository.save(newInvoice);
    }

    // Read an invoice by invoice id

    public Invoice readInvoice(Long id){
        return invoiceRepository.findById(id).orElseThrow(() -> new HttpClientErrorException.NotFound());
    }

    // Read all of the invoice associated to a customer

    public List<Invoice> getInvoicesForCustomer(Integer customerId){
        return invoiceRepository.findByCustomerId(customerId);
    }

    // Delete an invoice
    public void deleteInvoice(Long id){
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice does not exist or cannot be deleted"));
        invoiceRepository.delete(invoice);
    }


}

