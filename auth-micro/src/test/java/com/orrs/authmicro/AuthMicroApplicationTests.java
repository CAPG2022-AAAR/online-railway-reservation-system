package com.orrs.authmicro;

import com.orrs.authmicro.customer.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@SpringBootTest
class AuthMicroApplicationTests {

	@Autowired
	private  CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;


	@Test
	public void testJpaSave(){
		Customer customer = customerRepository.save(new Customer(
				"TestFname",
				"TestLname",
				"TestAddress",
				"99999999999",
				Gender.MALE,
				"TestPassword",
				"testEmail1@gmail.com",
				CustomerRole.USER
		));


		assertThat(customer.getId()).isGreaterThan(0);
	}

	@Test
	public void testJpadelete(){
		Optional<Customer> wrapperCustomer = customerRepository.findByEmail("testEmail1@gmail.com");
		Customer existingCustomer = wrapperCustomer.get();
		customerRepository.deleteById(existingCustomer.getId());

		assertThat(!customerRepository.findByEmail("testEmail1@gmail.com").isPresent());

	}



	@Test
	public void testRegistration(){

		String response = customerService.signUpCustomer(
				new Customer(
						"TestFname",
						"TestLname",
						"TestAddress",
						"99999999999",
						Gender.MALE,
						"TestPassword",
						"testEmail2@gmail.com",
						CustomerRole.USER
				)
		);

		assertThat(response.equals("Signed up perfectly)"));
	}
	@Test
	public void testJpaRetrieve(){

		Optional<Customer> wrapCustomer = customerRepository.findByEmail("testEmail2@gmail.com");
		Customer existingCustomer = wrapCustomer.get();
		assertThat(existingCustomer.getFname().equals("TestFname"));
	}
	@Test
	public void testUpdate(){
		Customer newCustomer = new Customer(
				"updatedTestFname",
				"updatedTestLname",
				"updatedTestAddress",
				"99999999999",
				Gender.MALE,
				"updatedTestPassword",
				"testEmail2@gmail.com",
				CustomerRole.USER
		);

		Optional<Customer> wrapperCustomer = customerRepository.findByEmail(newCustomer.getEmail());
		Customer  existingCustomer = wrapperCustomer.get();
		existingCustomer.setAddress(newCustomer.getAddress());
		existingCustomer.setFname(newCustomer.getFname());
		existingCustomer.setLname(newCustomer.getLname());
		existingCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
		existingCustomer.setGender(newCustomer.getGender());
		customerRepository.save(existingCustomer);

		Optional<Customer> newWrapperCustomer = customerRepository.findByEmail(newCustomer.getEmail());
		Customer updatedCustomer = newWrapperCustomer.get();

		assertThat(updatedCustomer.getFname().equals("updatedTestFname"));

	}

}
