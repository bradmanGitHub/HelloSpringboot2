package com.springboot.test.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.microservice.domain.Address;
import com.springboot.test.microservice.domain.Customer;
import com.springboot.test.microservice.domain.CustomerList;
import com.springboot.test.microservice.domain.Response;
import com.springboot.test.microservice.domain.User;
import com.springboot.test.microservice.service.CustomerInfoSvr;

@RestController
public class CustomerInfoService {
	@RequestMapping("/")
	public String sayHello() {
		return "Hello World";
	}

	@RequestMapping("/customers")
	public CustomerList getAllCustomer() {
		CustomerList allCustomer = new CustomerList();

		List<Customer> listCustomer = new ArrayList<Customer>();
		// mockup customer 1
		Address addr1 = new Address();
		addr1.setHomeNo("88/12");
		addr1.setVillage("village1");
		addr1.setRoad("road1");
		addr1.setTambon("tambon1");
		addr1.setAmphur("amphur1");
		addr1.setProvice("province1");
		addr1.setPostCode(11111);

		Customer cust1 = new Customer();
		cust1.setFirstName("Somchai");
		cust1.setLastName("Buayai");
		cust1.setAddress(addr1);

		listCustomer.add(cust1);

		// mockup customer 2
		Address addr2 = new Address();
		addr2.setHomeNo("99/22");
		addr2.setVillage("village2");
		addr2.setRoad("road2");
		addr2.setTambon("tambon2");
		addr2.setAmphur("amphur2");
		addr2.setProvice("province2");
		addr2.setPostCode(222222);

		Customer cust2 = new Customer();
		cust2.setFirstName("Michael");
		cust2.setLastName("Jordan");
		cust2.setAddress(addr2);

		listCustomer.add(cust2);

		allCustomer.setCustomerList(listCustomer);
		return allCustomer;
	}

	@RequestMapping(value = "/receiveCustomerJson", method = RequestMethod.POST)
	public ResponseEntity<Response> receiveCustomerJson(@RequestBody Customer customer) {

		System.out.println("\n==============[INPUT DATA]==================");
		System.out.println(customer.toString());

		Response response = new Response();
		response.setStatus("success");
		response.setMessage("Process done without-error");

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@Autowired
	CustomerInfoSvr customerService;	
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ResponseEntity<User> getUserDataFromAnotherRest(){
		User user = customerService.getUserRestCall();
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
