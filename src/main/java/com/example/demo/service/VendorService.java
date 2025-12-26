package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;

public interface VendorService {

    Vendor getVendorById(Long id);

    List<Vendor> getAllVendors();

    Vendor saveVendor(Vendor vendor);
}
