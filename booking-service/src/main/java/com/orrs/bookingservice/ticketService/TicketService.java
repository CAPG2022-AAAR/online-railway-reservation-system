package com.orrs.bookingservice.ticketService;



import com.orrs.bookingservice.emailDetail.EmailDetail;
import com.orrs.bookingservice.emailDetail.EmailServiceImplementation;
import com.orrs.bookingservice.ticketDetails.PaymentStatus;
import com.orrs.bookingservice.ticketDetails.SeatRequest;
import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private EmailServiceImplementation emailServiceImplementation;



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

        SeatRequest seatRequest = new SeatRequest(ticketDetails.getTrain_number()  , ticketDetails.getDate());
        int availableSeats = restTemplate.postForObject("http://AVAILABLE-TRAIN-INFO-SERVICE/api/v1/trains/get-available-seats" , seatRequest , Integer.class );

        TicketDetails createdTicket = new TicketDetails();

        if(availableSeats>=ticketDetails.getSeats()){
            createdTicket = ticketRepository.save(new TicketDetails(
                    ticketDetails.getF_name(),
                    ticketDetails.getL_name(),
                    ticketDetails.getGender(),
                    ticketDetails.getAddress(),
                    ticketDetails.getEmail(),
                    ticketDetails.getSeats(),
                    ticketDetails.getAmount(),
                    ticketDetails.getC_id(),
                    ticketDetails.getAge(),
                    ticketDetails.getTrain_number(),
                    ticketDetails.getSource_id(),
                    ticketDetails.getDestination_id(),
                    ticketDetails.getDeparture_time(),
                    ticketDetails.getDate(),
                    PaymentStatus.FAIL
            ));
        }else{
            throw new IllegalStateException("Seats not Available for this train");
        }




        String Message = "Your PNR for train ticket is = " + createdTicket.getPnr();
        String Name = "Name = " +createdTicket.getF_name() +" " +createdTicket.getL_name();
        String Seat = "Number of Booked Seats = " +createdTicket.getSeats();
        String Amount = "Ticket Price = " +createdTicket.getAmount();



        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setMessageBody(Message +"\n" +Name +"\n" +Seat +"\n" +Amount);
        emailDetail.setRecipient(createdTicket.getEmail());
        emailDetail.setSubject("PNR for ticket");



    String emailResponse = new String();

        if (createdTicket != null) {
             emailResponse = emailServiceImplementation.sendSimpleMail(emailDetail);
          }
        return createdTicket;
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


