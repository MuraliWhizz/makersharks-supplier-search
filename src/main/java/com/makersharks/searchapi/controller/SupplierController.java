
package com.makersharks.searchapi.controller;

import com.makersharks.searchapi.entity.Supplier;
import com.makersharks.searchapi.entity.NatureOfBusiness;
import com.makersharks.searchapi.entity.ManufacturingProcess;
import com.makersharks.searchapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
   
    private final SupplierService supplierService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred: " + e.getMessage());
    }

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) NatureOfBusiness natureOfBusiness,
            @RequestParam(required = false) ManufacturingProcess manufacturingProcess,
            @RequestParam(defaultValue = "10") int limit,
            Pageable pageable) {
        
        Page<Supplier> suppliers = supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcess, limit, pageable);
        return ResponseEntity.ok(suppliers);
    }

    @GetMapping("/query")
    public ResponseEntity<Page<Supplier>> getAllSuppliers(Pageable pageable) {
        Page<Supplier> suppliers = supplierService.findAllSuppliers(pageable);
        return ResponseEntity.ok(suppliers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        Supplier newSupplier = supplierService.createSupplier(supplier);
        return ResponseEntity.ok(newSupplier);
    }
}