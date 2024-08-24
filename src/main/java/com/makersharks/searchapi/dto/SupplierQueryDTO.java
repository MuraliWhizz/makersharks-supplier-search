package com.makersharks.searchapi.dto;

import com.makersharks.searchapi.entity.ManufacturingProcess;
import com.makersharks.searchapi.entity.NatureOfBusiness;

public class SupplierQueryDTO {
    private String location;
    private NatureOfBusiness natureOfBusiness;
    private ManufacturingProcess manufacturingProcess;

    // Getters and setters

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

    public ManufacturingProcess getManufacturingProcess() {
        return manufacturingProcess;
    }

    public void setManufacturingProcess(ManufacturingProcess manufacturingProcess) {
        this.manufacturingProcess = manufacturingProcess;
    }
}