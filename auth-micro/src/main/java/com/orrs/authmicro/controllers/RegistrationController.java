package com.orrs.authmicro.controllers;


import com.orrs.authmicro.customer.Customer;
import com.orrs.authmicro.registration.RegistrationRequest;
import com.orrs.authmicro.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        registrationService.register(request);
        return "User Registered";
    }
}
