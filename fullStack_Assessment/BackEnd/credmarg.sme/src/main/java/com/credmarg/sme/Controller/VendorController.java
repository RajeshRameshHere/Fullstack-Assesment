package com.credmarg.sme.Controller;

import com.credmarg.sme.Payload.VendorDTO;
import com.credmarg.sme.Payload.VendorResponse;
import com.credmarg.sme.Services.VendorService;
import com.credmarg.sme.ServicesImpl.VendorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendors")
@CrossOrigin("http://localhost:3003/")
public class VendorController {

private VendorServiceImpl vendorService;

public VendorController(VendorServiceImpl vendorService){
    this.vendorService=vendorService;
}

@PostMapping("/save")
public ResponseEntity<VendorDTO>saveVendor(@RequestBody VendorDTO vendorDTO){
    VendorDTO vendor = vendorService.saveVendor(vendorDTO);
    return new ResponseEntity<>(vendor, HttpStatus.CREATED);
}

@GetMapping("/showall")
public ResponseEntity<VendorResponse> ShowAllVendor(){
    VendorResponse vendorList = vendorService.showAllVendors();
    return new ResponseEntity<>(vendorList,HttpStatus.OK);
}

}
