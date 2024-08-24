package com.makersharks.searchapi.dto;

import com.makersharks.searchapi.entity.ManufacturingProcess;
import com.makersharks.searchapi.entity.NatureOfBusiness;

import java.util.Set;

public class SupplierResponseDTO {
    private Long supplierId;
    private String companyName;
    private String website;
    private String location;
    private NatureOfBusiness natureOfBusiness;
    private Set<ManufacturingProcess> manufacturingProcesses;

    // Getters and setters

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NatureOfBusiness getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public Set<ManufacturingProcess> getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(Set<ManufacturingProcess> manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }
}