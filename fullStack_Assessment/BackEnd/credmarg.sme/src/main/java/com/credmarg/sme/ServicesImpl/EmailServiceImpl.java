package com.credmarg.sme.ServicesImpl;

import com.credmarg.sme.Entity.EmailHistory;
import com.credmarg.sme.Entity.Vendor;
import com.credmarg.sme.Payload.EmailDTO;
import com.credmarg.sme.Payload.EmailResponse;
import com.credmarg.sme.Payload.VendorDTO;
import com.credmarg.sme.Repository.EmailRepository;
import com.credmarg.sme.Repository.VendorRepository;
import com.credmarg.sme.Services.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmailServiceImpl implements EmailService {

    private EmailRepository emailRepo;
    private VendorRepository vendorRepo;

    public EmailServiceImpl(EmailRepository emailRepo, VendorRepository vendorRepo){
        this.emailRepo=emailRepo;
        this.vendorRepo=vendorRepo;
    }



    @Override
    public VendorDTO vendorList(String email) {

        Vendor vendor = vendorRepo.findByEmail(email);
        VendorDTO vendorDTO = maptoDto(vendor);

        return vendorDTO;

    }

    @Override
    public void sendEmailToVendors( String to, String sub,String body) {

        vendorRepo.findByEmail(to);
//        emailRepo.save(EmailHistory);

        System.out.println("vendor email is:"+ to);
        System.out.println("subject:"+sub);
        System.out.println("email body:"+body);

    }

    @Override
    public EmailResponse showAllEmail() {
        List<EmailHistory> allEmails = emailRepo.findAll();
        List<EmailDTO> allEmailDto = allEmails.stream().map(e -> maptoEmailDto(e)).collect(Collectors.toList());

        EmailResponse emailResponse=new EmailResponse();
        emailResponse.setContents(allEmailDto);


        return emailResponse;
    }

    @Override
    public EmailDTO saveEmails(EmailDTO emailDTO) {

        EmailHistory emailHistory = mapTOEntity(emailDTO);
        EmailHistory save = emailRepo.save(emailHistory);

        return maptoEmailDto(save);
    }




    public EmailHistory mapTOEntity(EmailDTO emailDTO){
        EmailHistory details=new EmailHistory();
        details.setTo(emailDTO.getTo());
        details.setSub(emailDTO.getSub());
        details.setBody(emailDTO.getBody());
        return details;
    }
    public VendorDTO maptoDto(Vendor vendor){
        VendorDTO dto=new VendorDTO();
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setUpi(vendor.getUpi());
        return dto;
    }
    public EmailDTO maptoEmailDto(EmailHistory emailDTO){
        EmailDTO dto=new EmailDTO();
        dto.setTo(emailDTO.getTo());
        dto.setBody(emailDTO.getBody());
        dto.setSub(emailDTO.getSub());
        return dto;
    }

}
