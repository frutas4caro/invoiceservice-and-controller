package com.example.invoiceserviceandcontroller.repository;

import com.example.invoiceserviceandcontroller.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByCustomerId(Integer customerId);
}
