package com.orrs.bookingservice;


import com.orrs.bookingservice.ticketDetails.TicketDetails;
import com.orrs.bookingservice.ticketDetails.TicketRequest;
import com.orrs.bookingservice.ticketRepository.TicketRepository;
import com.orrs.bookingservice.ticketService.TicketService;
import org.junit.jupiter.api.Test;
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
		/*
		TicketDetails ticketDetail = new TicketDetails(
				1234L,
				"Akhil",
				"Sharma",
				"Male",
				"Lucknow",
				4,
				1892,
				165L,
				26,
				14267L,
				1542L,
				847L,
				637
		);

<<<<<<< HEAD
		TicketDetails ticketDetails3 = new TicketDetails(

				"Akhil",
				"Sharma",
				"Male",
				"Lucknow",
				4,
				1892,
				165L,
				26,
				14267L,
				1542L,
				847L,
				637
		);

		TicketRequest ticketRequest1 = new TicketRequest(
				"Akhil",
				"Sharma",
				"Male",
				"Lucknow",
				4,
				1892,
				26,
				165L,
				14267L,
				1542L,
				847L,
				637
		);


		when(ticketRepository.save(ticketDetails3)).thenReturn(ticketDetail);
		assertEquals("Akhil",ticketService.saveTicketDetails(ticketRequest1).getF_name());
	}

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

*/

		TicketDetails ticketDetails=new TicketDetails("Aman","Srivastava","Male","Lucknow",5,1024,1234L,23,1665L,1762L,1230L,1540);
		when(ticketRepository.save(ticketDetails)).thenReturn(ticketDetails);
		assertEquals("Aman",ticketService.saveTicketDetails(new TicketRequest().getF_name());
	}
}
