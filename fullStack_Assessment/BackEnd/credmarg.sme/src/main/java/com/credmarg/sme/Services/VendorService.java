package com.credmarg.sme.Services;

import com.credmarg.sme.Entity.Vendor;
import com.credmarg.sme.Payload.EmployeeResponse;
import com.credmarg.sme.Payload.VendorDTO;
import com.credmarg.sme.Payload.VendorResponse;

import java.util.List;

public interface VendorService {

    public VendorDTO saveVendor(VendorDTO vendorDTO);
    public VendorResponse showAllVendors();
}
