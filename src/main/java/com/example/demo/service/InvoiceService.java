package com.example.demo.service;

import com.example.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(Long id);

    void deleteInvoice(Long id);
}
