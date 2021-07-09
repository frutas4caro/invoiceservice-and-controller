package com.example.invoiceserviceandcontroller.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InvoiceNotFoundException extends RuntimeException{

    public InvoiceNotFoundException(Long id){
        super("Could not find Invoice " + id);
    }
}
