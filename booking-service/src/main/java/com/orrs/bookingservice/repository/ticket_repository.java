package com.orrs.bookingservice.repository;

import com.orrs.bookingservice.ticketDetails.TicketDetails;
 // import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ticket_repository extends JpaRepository<TicketDetails,Long> {
}
