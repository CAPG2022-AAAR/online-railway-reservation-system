package com.orrs.bookingservice.ticketRepository;

import com.orrs.bookingservice.ticketDetails.TicketDetails;
 // import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketDetails,Long> {
}
