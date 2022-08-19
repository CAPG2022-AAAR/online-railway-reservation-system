package com.orrs.authmicro.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {



    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final String  USER_NOT_FOUND = "Customer with email %s not found";
    private final CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return customerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND,email)));
    }
    public String signUpCustomer(Customer customer){
        boolean customerExists = customerRepository.findByEmail(customer.getEmail())
                .isPresent();
        if(customerExists){
            throw new IllegalStateException("User with Email already exist!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerRepository.save(customer);

        return "Signed up perfectly";
    }

    public String currentUsername(Principal principal){
        return principal.getName();
    }




    public Customer updateCustomer(Customer customer){

        //Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //String userName = currentUsername((Principal) principal);

        boolean customerExists = customerRepository.findByEmail(customer.getEmail()).isPresent();
        if(customerExists){

            Optional<Customer> wrapperCustomer = customerRepository.findByEmail(customer.getEmail());
            Customer  existingCustomer = wrapperCustomer.get();
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setFname(customer.getFname());
            existingCustomer.setLname(customer.getLname());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            existingCustomer.setGender(customer.getGender());
            customerRepository.save(existingCustomer);
            return existingCustomer;
        }else{
            throw new IllegalStateException("User doesn't exist in database");
        }


    }
}
