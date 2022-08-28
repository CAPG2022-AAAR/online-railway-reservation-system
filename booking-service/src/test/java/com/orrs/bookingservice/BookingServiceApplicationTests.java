package com.orrs.bookingservice;

import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import com.orrs.bookingservice.ticketService.TicketService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class BookingServiceApplicationTests {

	@Autowired
	TicketService ticketService;

	@MockBean
	TicketRepository ticketRepository;


	@Test
	void saveTicketDetails() {


		TicketDetails ticketDetails1 = new TicketDetails(
				12345L,
				"Aman",
				"Singh",
				"male",
				"lucknow",
				5,
				1084,
				153L,
				22,
				14277L,
				1536L,
				857L,
				657);

		TicketDetails ticketDetails2 = new TicketDetails(
				"Aman",
				"Singh",
				"male",
				"lucknow",
				5,
				1084,
				153L,
				22,
				14277L,
				1536L,
				857L,
				657);

		TicketRequest ticketRequest = new TicketRequest(
				"Aman",
				"Singh",
				"male",
				"lucknow",
				5,
				1084,
				22,
				153L,
				14277L,
				1536L,
				857L,
				657);


		when(ticketRepository.save(ticketDetails2)).thenReturn(ticketDetails1);
		assertEquals("Aman", ticketService.saveTicketDetails(ticketRequest).getF_name());

	}
}



