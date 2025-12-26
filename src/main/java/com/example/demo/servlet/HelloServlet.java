package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;

public class HelloServlet extends HttpServlet {
    // servlet code only



    Vendor createVendor(Vendor vendor);

    Vendor getVendor(Long vendorId);

    List<Vendor> getAllVendors();
}
