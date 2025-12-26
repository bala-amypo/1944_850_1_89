package com.example.demo.service;

import com.example.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {

    Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice);

    Invoice getInvoice(Long invoiceId);

    List<Invoice> getInvoicesByUser(Long userId);

    Invoice categorizeInvoice(Long invoiceId);
}
