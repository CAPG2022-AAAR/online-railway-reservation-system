package com.orrs.authmicro.customer;

import com.orrs.authmicro.registration.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements UserDetailsService {



    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final  String  USERNOTFOUND = "Customer with email %s not found";
    private final CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return customerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USERNOTFOUND,email)));
    }
    public Customer signUpCustomer(Customer customer){


        boolean customerExists = customerRepository.findByEmail(customer.getEmail())
                .isPresent();

        if(customerExists){
            throw new IllegalStateException("User with Email already exist!");
        }

        if(customer.getPassword().equals("")){
            throw new IllegalStateException("Password cannot be empty");
        }

        if(customer.getFname().equals("") || customer.getFname().isEmpty()){
            throw new IllegalStateException("Name cannot be empty");
        }


        if(customer.getAddress().equals("")){
            throw new IllegalStateException("Address cannot be empty");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        return customerRepository.save(customer);
    }





    public Customer updateCustomer(RegistrationRequest customer){

        boolean customerExists = customerRepository.findByEmail(customer.getEmail()).isPresent();
        Customer  existingCustomer = null;
        if(customerExists){
            Optional<Customer> wrapperCustomer = customerRepository.findByEmail(customer.getEmail());
            if(wrapperCustomer.isPresent()){
                existingCustomer = wrapperCustomer.get();
                existingCustomer.setAddress(customer.getAddress());
                existingCustomer.setFname(customer.getFname());
                existingCustomer.setLname(customer.getLname());
                existingCustomer.setPhoneNumber(customer.getPhone());
                existingCustomer.setGender(customer.getGender());
                customerRepository.save(existingCustomer);
            }
            return existingCustomer;
        }else{
            throw new IllegalStateException("User doesn't exist");
        }


    }
    public String deleteCustomerByEmailId(String email){

        Optional<Customer> wrapperCustomer = customerRepository.findByEmail(email);
        if(wrapperCustomer.isPresent()){

                Customer  existingCustomer = wrapperCustomer.get();
                customerRepository.deleteById(existingCustomer.getId());

                return "Customer Deleted Successfully!";

        }else{
            throw new IllegalStateException("User Not Found");
        }
    }
}
