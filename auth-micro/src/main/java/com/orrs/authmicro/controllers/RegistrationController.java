package com.orrs.authmicro.controllers;


import com.orrs.authmicro.customer.Customer;
import com.orrs.authmicro.registration.RegistrationRequest;
import com.orrs.authmicro.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3006")
    public String register(@RequestBody RegistrationRequest request){
        registrationService.register(request);
        return "User Registered";
    }
}
