package com.orrs.authmicro.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentGateway")
public class PaymentController {

    @GetMapping
    public String makePayment(){
        return "Payments done here";
    }
}
