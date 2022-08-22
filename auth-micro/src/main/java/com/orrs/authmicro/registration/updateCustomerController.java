package com.orrs.authmicro.registration;


import com.orrs.authmicro.customer.Customer;
import com.orrs.authmicro.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/update")
@AllArgsConstructor
public class updateCustomerController {

    private  RegistrationService registrationService;
    private CustomerService customerService;


    @PostMapping
    public Customer update(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

}
