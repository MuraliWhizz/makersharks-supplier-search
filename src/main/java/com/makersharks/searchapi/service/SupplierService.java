
// package com.makersharks.searchapi.service;

// import com.makersharks.searchapi.entity.Supplier;
// import com.makersharks.searchapi.entity.NatureOfBusiness;
// import com.makersharks.searchapi.entity.ManufacturingProcess;
// import com.makersharks.searchapi.repository.SupplierRepository;
// import com.makersharks.searchapi.exception.ResourceNotFoundException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// @Service
// public class SupplierService {

//     private final SupplierRepository supplierRepository;

//     @Autowired
//     public SupplierService(SupplierRepository supplierRepository) {
//         this.supplierRepository = supplierRepository;
//     }

//     public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness, 
//                                         ManufacturingProcess manufacturingProcess, Pageable pageable) {
//         return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, pageable);
//     }

//     public Page<Supplier> findAllSuppliers(Pageable pageable) {
//         return supplierRepository.findAll(pageable);
//     }
//     public Supplier createSupplier(Supplier supplier) {
//         return supplierRepository.save(supplier);
//     }

//     public Supplier updateSupplier(Long id, Supplier supplier) {
//         Supplier existingSupplier = supplierRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        
//         existingSupplier.setCompanyName(supplier.getCompanyName());
//         existingSupplier.setWebsite(supplier.getWebsite());
//         existingSupplier.setLocation(supplier.getLocation());
//         existingSupplier.setNatureOfBusiness(supplier.getNatureOfBusiness());
//         existingSupplier.setManufacturingProcesses(supplier.getManufacturingProcesses());

//         return supplierRepository.save(existingSupplier);
//     }
// }

package com.makersharks.searchapi.service;

import com.makersharks.searchapi.entity.Supplier;
import com.makersharks.searchapi.entity.NatureOfBusiness;
import com.makersharks.searchapi.entity.ManufacturingProcess;
import com.makersharks.searchapi.repository.SupplierRepository;
import com.makersharks.searchapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness, 
                                        ManufacturingProcess manufacturingProcess, int limit, Pageable pageable) {
        // Create a new PageRequest with the limit as the page size
        Pageable limitedPageable = PageRequest.of(0, limit, pageable.getSort());
        return supplierRepository.findSuppliers(location, natureOfBusiness, manufacturingProcess, limitedPageable);
    }

    // Other methods remain unchanged
    public Page<Supplier> findAllSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
        
        existingSupplier.setCompanyName(supplier.getCompanyName());
        existingSupplier.setWebsite(supplier.getWebsite());
        existingSupplier.setLocation(supplier.getLocation());
        existingSupplier.setNatureOfBusiness(supplier.getNatureOfBusiness());
        existingSupplier.setManufacturingProcesses(supplier.getManufacturingProcesses());

        return supplierRepository.save(existingSupplier);
    }
}