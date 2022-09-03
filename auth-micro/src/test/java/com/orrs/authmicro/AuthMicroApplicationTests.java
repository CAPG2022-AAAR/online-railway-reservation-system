package com.orrs.authmicro;

import com.orrs.authmicro.customer.*;


import com.orrs.authmicro.registration.EmailValidator;
import com.orrs.authmicro.controllers.RegistrationController;
import com.orrs.authmicro.registration.RegistrationRequest;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
class AuthMicroApplicationTests {





	@Autowired
	private  CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	void testSave(){
		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals("Anurag" , customerService.signUpCustomer(customer).getFname());
	}


	@Test
	void testUpdate(){

		Customer existingCustomer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		RegistrationRequest updatedCustomer = new RegistrationRequest(
				"updatedAnurag",
				"updatedPanwar",
				"anu10300@gmail.com",
				"anurag",
				"updated address",
				35,
				Gender.MALE,
				"999999999"
		);



		when(customerRepository.findByEmail(updatedCustomer.getEmail())).thenReturn(Optional.of(existingCustomer));
		when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);
		assertEquals( "updatedAnurag" , customerService.updateCustomer(updatedCustomer).getFname() );

	}


	@Test
	void testLoadUserByUsername(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER
		);

		Optional<Customer> optCus = Optional.of(customer);

		when(customerRepository.findByEmail(customer.getEmail())).thenReturn(optCus);

		assertEquals("Anurag" , optCus.get().getFname());

	}

	@Test
	void testDeleteCustomerByEmailId(){


		Customer customer = new Customer(
				11234L,
				"Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER
		);

		String email = "anu10300@gmail.com";

		Optional<Customer> optCus = Optional.of(customer);
		when(customerRepository.findByEmail(email)).thenReturn(optCus);
		String response = customerService.deleteCustomerByEmailId(email);
		verify(customerRepository, times(1)).deleteById(customer.getId());


	}

	@Test
	void testGetUsername(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		assertEquals("anu10300@gmail.com" , customer.getUsername());

	}

	@Autowired
	private EmailValidator validator;

	@Test
	void testEmailValidator(){
		String email = "anu10300@gmail.com";

		assertEquals(true , validator.test(email));
	}

	@Autowired
	RegistrationController controller;



	@Test
	void testRegisterEmailValidation(){
		

		RegistrationRequest updatedCustomer = new RegistrationRequest(
				"Anurag",
				"Panwar",
				"1234",
				"password",
				"Colony 123",
				35,
				Gender.MALE,
				"1234567890"
		);

		String expected = "Email Not Valid!";


		Exception thrown =    assertThrows(IllegalStateException.class , ()-> {
			controller.register(updatedCustomer);
		});

		assertEquals(thrown.getMessage() , expected);

	}

	@Test
	void testCustomerExpiration(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		assertEquals(true , customer.isAccountNonExpired());

	}

	@Test
	void testCustomerLock(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		assertEquals(true , customer.isAccountNonLocked());

	}

	@Test
	void testCustomerCredentialExpiration(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		assertEquals(true , customer.isCredentialsNonExpired());

	}

	@Test
	void testCustomerAccountEnabled(){

		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		assertEquals(true , customer.isEnabled());

	}

	@Test
	void testAuthorityPresence(){
		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );

		List<GrantedAuthority> list = (List<GrantedAuthority>) customer.getAuthorities();
		assertEquals(false , list.isEmpty());

	}

	@Test
	void testRegistrationRequestToString(){
		RegistrationRequest updatedCustomer = new RegistrationRequest(
				"Anurag",
				"Panwar",
				"1234",
				"password",
				"Colony 123",
				35,
				Gender.MALE,
				"1234567890"
		);
		assertEquals("RegistrationRequest(fname=Anurag, lname=Panwar, email=1234, password=password, address=Colony 123, age=35, gender=MALE, phone=1234567890)" , updatedCustomer.toString());
	}

	@Test
	void testCustomerToString(){
		Customer customer = new Customer("Anurag",
				"Panwar",
				"Colony 123",
				"1234567890",
				Gender.MALE,
				"password",
				"anu10300@gmail.com",
				CustomerRole.USER );
		assertEquals("Customer(id=null, fname=Anurag, lname=Panwar, address=Colony 123, phoneNumber=1234567890, gender=MALE, password=password, email=anu10300@gmail.com, customerRole=USER, locked=false, enabled=true)" , customer.toString());
	}



}
