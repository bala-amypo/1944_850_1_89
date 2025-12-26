package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@Tag(name = "Vendors Endpoints")
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    @Operation(summary = "Create vendor")
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return ResponseEntity.ok(vendorService.createVendor(vendor));
    }

    @Operation(summary = "List vendors")
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @Operation(summary = "Get vendor by id")
    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendor> getVendor(@PathVariable Long vendorId) {
        return ResponseEntity.of(
                vendorService.getAllVendors()
                        .stream()
                        .filter(v -> v.getId().equals(vendorId))
                        .findFirst()
        );
    }
}
