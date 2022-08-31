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
	private TicketService ticketService;

	@MockBean
	private TicketRepository ticketRepository;


	@Test
	void saveTicketDetails() {


		TicketDetails ticketDetails = new TicketDetails(
				"Aman",
				"Singh",
				"male",
				"lucknow",
				5,
				1084,
				222L,
				15,
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
				15,
				222L,
				14277L,
				1536L,
				857L,
				657);


		when(ticketRepository.save(ticketDetails)).thenReturn(ticketDetails);
		assertEquals(222,ticketService.saveTicketDetails(ticketRequest).getC_id());

	}
}



