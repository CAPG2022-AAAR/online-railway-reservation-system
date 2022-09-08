package com.orrs.paymentservice.controller;

import com.orrs.paymentservice.entity.Order;
import com.orrs.paymentservice.messageQueue.CustomMessage;
import com.orrs.paymentservice.messageQueue.MQConfig;
import com.orrs.paymentservice.messageQueue.TicketSuccessMessage;
import com.orrs.paymentservice.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;


@RestController
public class PaypalController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

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
                "Http://localhost:8082pay/cancel/"+order.getPnr(),
                "Http://localhost:8082/pay/success/"+order.getPnr()
        );

        for(Links link:payment.getLinks() ){
            if(link.getRel().equals("approval_url")){
                return "redirect:"+link.getHref();
            }
        }

        return "redirect:/";
    }

    @GetMapping("/pay/cancel/{pnr}")
    public String cancelPay(@PathVariable("pnr") long pnr) {
        String strPnr = Long.toString(pnr);
        TicketSuccessMessage customMessage = new TicketSuccessMessage();
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        customMessage.setMessage("c"+strPnr);
        rabbitTemplate.convertAndSend(MQConfig.TICKETE,
                MQConfig.TICKET_MESSAGE_ROUTING_KEY,
                customMessage);
        return "cancel ticket";
    }

    @GetMapping("/pay/success/{pnr}")
    public String successPay(//@RequestParam("paymentId") String paymentId ="1234",
                             //@RequestParam("PayerID") String payerId = "1234",
                             @PathVariable("pnr") long pnr) throws PayPalRESTException {

            //Payment payment = service.executePayment(paymentId, payerId);

            //System.out.println(payment.toJSON());

          //  if (payment.getState().equals("approved")) {
                String strPnr = Long.toString(pnr);

                TicketSuccessMessage customMessage = new TicketSuccessMessage();
                customMessage.setMessageId(UUID.randomUUID().toString());
                customMessage.setMessageDate(new Date());
                customMessage.setMessage("s"+strPnr);
                rabbitTemplate.convertAndSend(MQConfig.TICKETE,
                        MQConfig.TICKET_MESSAGE_ROUTING_KEY,
                        customMessage);
                return "payment succesfull";

           // }

      //  return "redirect:/";
    }


}
