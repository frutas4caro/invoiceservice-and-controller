package com.example.invoiceserviceandcontroller.utilities;

import com.example.invoiceserviceandcontroller.model.Invoice;
import com.example.invoiceserviceandcontroller.repository.InvoiceRepository;
import com.example.invoiceserviceandcontroller.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    InvoiceService invoiceService;

    @Bean
    CommandLineRunner initDatabase(InvoiceRepository invoiceRepository) {


        return args -> {
            log.info("Preloading Invoice " + invoiceService.createInvoice(
                    new Invoice(1, "102233", "Staples", 23.50,
                            "Paper Products")));
            log.info("Preloading Invoice " + invoiceService.createInvoice(
                    new Invoice(1, "102240", "Whole Foods", 102.35,
                            "Groceries for Networking Event")));
            log.info("Preloading Invoice " + invoiceService.createInvoice(
                    new Invoice(2, "99999", "Best Buy", 1050.00,
                            "10 Computer Screens")));
            log.info("Preloading Invoice " + invoiceService.createInvoice(
                    new Invoice(2, "84009", "Ikea", 250.50,
                            "Desk Chairs x 3")));
            log.info("Preloading Invoice " + invoiceService.createInvoice(
                    new Invoice(3, "77723", "Staples", 35.99,
                            "Office Supplies")));
        };
    }
}
