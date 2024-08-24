package com.makersharks.searchapi.repository;

import com.makersharks.searchapi.entity.Supplier;
import com.makersharks.searchapi.entity.NatureOfBusiness;
import com.makersharks.searchapi.entity.ManufacturingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE " +
           "(:location IS NULL OR s.location = :location) AND " +
           "(:natureOfBusiness IS NULL OR s.natureOfBusiness = :natureOfBusiness) AND " +
           "(:manufacturingProcess IS NULL OR :manufacturingProcess MEMBER OF s.manufacturingProcesses)")
    Page<Supplier> findSuppliers(
            @Param("location") String location,
            @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
            @Param("manufacturingProcess") ManufacturingProcess manufacturingProcess,
            Pageable pageable);
}