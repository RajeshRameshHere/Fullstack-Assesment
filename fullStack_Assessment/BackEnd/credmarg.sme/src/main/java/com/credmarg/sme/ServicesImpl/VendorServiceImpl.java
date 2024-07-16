package com.credmarg.sme.ServicesImpl;

import com.credmarg.sme.Entity.Employee;
import com.credmarg.sme.Entity.Vendor;
import com.credmarg.sme.Payload.EmployeeDTO;
import com.credmarg.sme.Payload.EmployeeResponse;
import com.credmarg.sme.Payload.VendorDTO;
import com.credmarg.sme.Payload.VendorResponse;
import com.credmarg.sme.Repository.VendorRepository;
import com.credmarg.sme.Services.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private VendorRepository vendorRepo;
  public VendorServiceImpl(VendorRepository vendorRepo){
        this.vendorRepo=vendorRepo;
    }
    @Override
    public VendorDTO saveVendor(VendorDTO vendorDTO) {

        Vendor vendor = mapToEntity(vendorDTO);
        Vendor saved = vendorRepo.save(vendor);
        return maptoDTO(saved);
    }

    @Override
    public VendorResponse showAllVendors() {
        List<Vendor> allVendors = vendorRepo.findAll();
        List<VendorDTO> allVendorDTO = allVendors.stream().map(e -> maptoDTO(e)).collect(Collectors.toList());

        VendorResponse response=new VendorResponse();
        response.setContents(allVendorDTO);


        return response;
    }

    public Vendor mapToEntity(VendorDTO vendorDTO){
      Vendor newVendor=new Vendor();
      newVendor.setName(vendorDTO.getName());
      newVendor.setEmail(vendorDTO.getEmail());
      newVendor.setUpi(vendorDTO.getUpi());
      return newVendor;
    }

    public VendorDTO maptoDTO(Vendor vendor){
        VendorDTO dto=new VendorDTO();
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setUpi(vendor.getUpi());
                return dto;
    }
}
