package com.example.invoiceserviceandcontroller.service;

import com.example.invoiceserviceandcontroller.model.Invoice;
import com.example.invoiceserviceandcontroller.repository.InvoiceRepository;
import com.example.invoiceserviceandcontroller.utilities.InvoiceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice newInvoice){
        return invoiceRepository.save(newInvoice);
    }

    public Invoice readInvoice(Long id){
        return invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException(id));
    }

    public List<Invoice> getInvoicesForCustomer(Integer customerId){
        return invoiceRepository.findByCustomerId(customerId);
    }

    public void deleteInvoice(Long id){
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Invoice does not exist or cannot be deleted"));
        invoiceRepository.delete(invoice);
    }
    
    public Invoice updateInvoice(Invoice updatedInvoice, Long id) {

        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {

            invoice.get().setInvoiceNumber(updatedInvoice.getInvoiceNumber());
            invoice.get().setInvoiceDescription(updatedInvoice.getInvoiceDescription());
            invoice.get().setAmount(updatedInvoice.getAmount());
            invoice.get().setCustomerId(updatedInvoice.getCustomerId());
            invoice.get().setVendorName(updatedInvoice.getVendorName());
            return invoiceRepository.save(invoice.get());

        } else{
            throw new InvoiceNotFoundException(id);
        }
    }
}

