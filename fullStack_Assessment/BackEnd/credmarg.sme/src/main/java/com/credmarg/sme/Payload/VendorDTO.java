package com.credmarg.sme.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VendorDTO {

    private String name;
    private String email;
    private String upi;

}
