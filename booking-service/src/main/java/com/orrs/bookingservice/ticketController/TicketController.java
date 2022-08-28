package com.orrs.bookingservice.ticketController;

// import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketService.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket_details")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping
    public String getMessage() {
        return "welcome to online railway reservation system for booking ";

    }


    /*      @GetMapping("/api/v1/ticket")
       private List<TicketDetails> getAllTicketDetails() {

            return ticketService.getAllTicketDetails();
       }
    */
    // creating a post mapping that will post the ticket details in the database
    @PostMapping("/create")
    public TicketDetails saveTicketDetails(@RequestBody TicketRequest ticketRequest) {
        return ticketService.saveTicketDetails(ticketRequest);

    }

    /*
    @GetMapping("/api/v1/showTicket/{pnr}")
    public TicketDetails findByPnr(@PathVariable int id){
        TicketDetails response = ticketService.findById(id);
        return response;
    }
*/

    //  creating delete mapping that deletes a specified ticket

    @DeleteMapping("/delete/{id}")
    private void deleteTicketDetails(@PathVariable("id") int id) {
        ticketService.deleteTicketDetails((long) id);
    }
}
    // creating a put mapping that updates the ticket details.

/*
    @PutMapping("/update/{id}")
    private ResponseEntity<TicketDetails> updateTicketdDetais(@PathVariable (value="id") int id, @RequestBody TicketDetails ticketDetails){
        return ticketService.updateTicketDetails(id,ticketDetails);
    }
}
*/






