package com.orrs.authmicro.registration;


import com.orrs.authmicro.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete")
@AllArgsConstructor
public class DeleteController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/{emailId}")
    public String deleteUser(@PathVariable("emailId") String emailId){
        return customerService.deleteCustomerByEmailId(emailId);

    }

}
