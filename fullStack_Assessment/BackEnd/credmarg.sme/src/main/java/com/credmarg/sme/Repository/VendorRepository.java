package com.credmarg.sme.Repository;

import com.credmarg.sme.Entity.Vendor;
import com.credmarg.sme.Payload.VendorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> {

    Vendor findByEmail(String email);
}
