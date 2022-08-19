package com.orrs.authmicro.registration;


import com.orrs.authmicro.customer.Gender;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class RegistrationRequest {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String address;
    private int age;
    private Gender gender;
    private String phone;

}
