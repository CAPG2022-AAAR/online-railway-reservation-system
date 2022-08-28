package com.orrs.authmicro.controllers;


import com.orrs.authmicro.DTO.TicketDTO;
import com.orrs.authmicro.entity.Ticket;
import com.orrs.authmicro.entity.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bookticket")
public class TicketController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String bookTicket(){
        return "Book your ticket here";
    }



    //returns ticket after creation
    @PostMapping
    public TicketDetails bookedTicket(@RequestBody TicketDTO ticketDTO){

        TicketDTO request1 = new TicketDTO(
                "Anurag",
                "Panwar",
                "MALE",
                "123",
                6,
                100,
                30,
                12L,
                101L,
                500L,
                501L,
                1200
        );



        TicketDetails ticketDetails = new TicketDetails();
        ticketDetails = restTemplate.postForObject("http://localhost:8081/api/v1/ticket_details/create", ticketDTO , TicketDetails.class  );

        //TODO: generate ticket from ticketDetails then send only relevant information(not the whole ticketDetails
        return ticketDetails;
    }
}
