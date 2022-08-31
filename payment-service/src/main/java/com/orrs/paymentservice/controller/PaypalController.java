package com.orrs.paymentservice.controller;

import com.orrs.paymentservice.entity.Order;
import com.orrs.paymentservice.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PaypalController {

    public static final String SUCCESS_URL = "pay/success";

    public static final String CANCEL_URL = "pay/cancel";

    @Autowired
    PaypalService service;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") Order order) throws PayPalRESTException {

        Payment payment =  service.createPayment(
                order.getPrice(),
                order.getCurrency(),
                order.getMethod(),
                order.getIntent(),
                order.getDescription(),
                "Http://localhost:8082"+CANCEL_URL,
                "Http://localhost:8082"+SUCCESS_URL
        );

        for(Links link:payment.getLinks() ){
            if(link.getRel().equals("approval_url")){
                return "redirect:"+link.getHref();
            }
        }

        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) throws PayPalRESTException {

            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }

        return "redirect:/";
    }


}
