package com.orrs.authmicro.registration;


import com.orrs.authmicro.customer.Customer;
import com.orrs.authmicro.customer.CustomerRole;
import com.orrs.authmicro.customer.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final CustomerService customerService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());



        if(!isValidEmail){
            throw new IllegalStateException("Email Not Valid!");
        }

        return customerService.signUpCustomer(
                new Customer(
                        request.getFname(),
                        request.getLname(),
                        request.getAddress(),
                        request.getPhone(),
                        request.getGender(),
                        request.getPassword(),
                        request.getEmail(),
                        CustomerRole.USER
                )
        );
    }
}
