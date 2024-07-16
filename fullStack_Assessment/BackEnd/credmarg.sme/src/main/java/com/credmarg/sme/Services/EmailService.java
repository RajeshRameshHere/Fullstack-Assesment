package com.credmarg.sme.Services;

import com.credmarg.sme.Entity.EmailHistory;
import com.credmarg.sme.Payload.EmailDTO;
import com.credmarg.sme.Payload.EmailResponse;
import com.credmarg.sme.Payload.EmployeeResponse;
import com.credmarg.sme.Payload.VendorDTO;

import java.util.List;

public interface EmailService {


    public VendorDTO vendorList(String email);


    public void sendEmailToVendors( String to, String sub,String body);

    public EmailResponse showAllEmail();



    public EmailDTO saveEmails(EmailDTO emailDTO);

}
