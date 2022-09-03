package com.orrs.authmicro.controllers;


import com.orrs.authmicro.customer.Customer;
import com.orrs.authmicro.customer.CustomerService;
import com.orrs.authmicro.registration.RegistrationRequest;
import com.orrs.authmicro.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
@AllArgsConstructor
public class UpdateCustomerController {

    private RegistrationService registrationService;
    private CustomerService customerService;


    @PostMapping
    public Customer update(@RequestBody RegistrationRequest requestedCustomer){
        return customerService.updateCustomer(requestedCustomer);
    }

}
