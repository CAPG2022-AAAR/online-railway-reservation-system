package com.orrs.bookingservice;

import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import com.orrs.bookingservice.ticketService.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
class BookingServiceApplicationTests {

	@Autowired
	private TicketService ticketService;

	@MockBean
	private TicketRepository ticketRepository;


	@Test
	void saveTicketDetails() {
	/*
		TicketRequest ticketRequest = new TicketRequest("Akshay",
				"Singh",
				"male",
				"lucknow",
				5,
				1084,
				22L,
				153,
				14277L,
				1536L,
				857L,
				657);

		when(ticketRepository.save(TicketRequest)).thenReturn(ticketDetails);
		assertEquals("Akshay", ticketService.saveTicketDetails(new TicketRequest()).getF_name());
	*/
	}
}



