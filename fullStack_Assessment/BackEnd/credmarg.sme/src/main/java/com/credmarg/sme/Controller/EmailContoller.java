package com.credmarg.sme.Controller;

import com.credmarg.sme.Payload.EmailDTO;
import com.credmarg.sme.Payload.EmailResponse;
import com.credmarg.sme.Payload.VendorDTO;
import com.credmarg.sme.ServicesImpl.EmailServiceImpl;
import com.credmarg.sme.ServicesImpl.VendorServiceImpl;
import com.credmarg.sme.Util.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("http://localhost:3003")
public class EmailContoller {

    private EmailServiceImpl emailService;
    private VendorServiceImpl vendorService;

    public EmailContoller(EmailServiceImpl emailService, VendorServiceImpl vendorService) {
        this.emailService = emailService;
        this.vendorService = vendorService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmailToVendors(@RequestBody EmailRequest emailRequest) {
        List<String> vendorEmails = emailRequest.getVendorEmails();

        for (String vendorEmail : vendorEmails) {
            // Assuming emailService can retrieve vendors by email
            VendorDTO vendor = emailService.vendorList(vendorEmail);
            if (vendor != null) {
                String message = "Payment Notification: This payment is the notification for " + vendor.getName() +
                        " and the UPI ID is followed by: " + vendor.getUpi();
                String subject="Payment Notification";
                emailService.sendEmailToVendors(vendorEmail,subject, message);
                EmailDTO emailDTO=new EmailDTO();
                emailDTO.setTo(vendorEmail);
                emailDTO.setSub(subject);
                emailDTO.setBody(message);
                emailService.saveEmails(emailDTO);
            } else {
                System.out.println("null");
            }

        }
          return new ResponseEntity<>("Emails sent successfully", HttpStatus.OK);
    }

    @GetMapping("/inbox")
    public ResponseEntity<EmailResponse> emailInbox(){
        EmailResponse emailResponse = emailService.showAllEmail();
        return new ResponseEntity<>(emailResponse,HttpStatus.OK);

    }
}
