package com.orrs.bookingservice.ticketService;


import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

/*
    // getting all the ticket records by using the method findAll() of Crud Repository
    public List<TicketDetails> getAllTicketDetails() {

        List<TicketDetails> ticketDetails = new ArrayList<TicketDetails>();
        ticketRepository.findAll().forEach(ticketDetails1 -> ticketDetails.add(ticketDetails1));
        return ticketDetails;
    }
*/
    // saving a specific record by using the method save() of crud repository
    public TicketDetails saveTicketDetails(TicketRequest ticketDetails) {
        return ticketRepository.save(new TicketDetails(
                ticketDetails.getF_name(),
                ticketDetails.getL_name(),
                ticketDetails.getGender(),
                ticketDetails.getAddress(),
                ticketDetails.getSeats(),
                ticketDetails.getAmount(),
                ticketDetails.getC_id(),
                ticketDetails.getAge(),
                ticketDetails.getTrain_number(),
                ticketDetails.getSource_id(),
                ticketDetails.getDestination_id(),
                ticketDetails.getDeparture_time()
        ));
    }

    // deleting a specific record by using the method deleteById() of crud repository
    public void deleteTicketDetails(Long id) {
        ticketRepository.deleteById(id);

    }

    //updating the record
    public ResponseEntity<TicketDetails> updateTicketDetails(int id, TicketDetails ticketDetails) {
    return null;
    }

    // getting a specific record by using   the method findById() of crud repository
    public TicketDetails findById(long id) {
        return ticketRepository.findById(id).get();

    }
}

