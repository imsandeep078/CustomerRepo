package com.customer.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.dto.QueryDataResponse;
import com.customer.entity.CustomerDetails;
import com.customer.entity.ProductDetails;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	private String responseMessage;

	private static Logger logger = Logger.getLogger("CustomerController");

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody @Valid CustomerDetails details) {
		CustomerDetails result = service.saveCustomer(details);
		responseMessage = "Added successfully..and customer id is " + result.getCustomerId();
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("/addCustomer") public ResponseEntity<CustomerDetails>
	 * saveCustomer(@RequestBody @Valid CustomerDetails details) {
	 * 
	 * 
	 * try { repository.save(details); return
	 * ResponseEntity.status(HttpStatus.CREATED).build(); } catch (Exception e) {
	 * e.printStackTrace(); return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
	 * 
	 * 
	 * repository.save(details); return new
	 * ResponseEntity<>(repository.save(details), HttpStatus.CREATED);
	 * 
	 * }
	 */

	@GetMapping("/search/{lastName}")
	public ResponseEntity<List<CustomerDetails>> searchByLastName(@PathVariable("lastName") String lastName) {
		List<CustomerDetails> customerDetails = service.searchWithLastName(lastName);
		return new ResponseEntity<>(customerDetails, HttpStatus.FOUND);
	}

	/*
	 * @GetMapping("/search/{lastName}") public CustomerDetails
	 * searchWithLastName(@PathVariable("lastName") String lastName) {
	 * CustomerDetails customerDetails = repository.findByLastName(lastName); if
	 * (customerDetails == null) { throw new
	 * CustomerNotFoundException("Customer not found with last name :" + lastName);
	 * } return customerDetails; }
	 */

	@GetMapping("/getAllInfo")
	public ResponseEntity<List<CustomerDetails>> getAllCustomers() {
		logger.info("GetAllCustomers---------->");
		List<CustomerDetails> custList = (List<CustomerDetails>) service.listOfCustomerDetails();
		logger.info("GetAllCustomers RETURNED---------->");
		return new ResponseEntity<>(custList, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/getAllInfo") public ResponseEntity<List<CustomerDetails>>
	 * getAllCustomers() { List<CustomerDetails> custList = (List<CustomerDetails>)
	 * repository.findAll(); if (custList.size() <= 0) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); } return
	 * ResponseEntity.of(Optional.of(custList)); }
	 */

	@DeleteMapping("/search/delete/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable("id") long id) {

		if (service.deleteCustomer(id)) {
			responseMessage = "Id " + id + " has been removed from DB successfully!!";
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			responseMessage = "Data not deleted correctlly!!";
			return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<List<String>> findProductNameWithId(@PathVariable("id") long id) {
		List<String> details = service.getProductWithId(id);
		return new ResponseEntity<List<String>>(details, HttpStatus.FOUND);
	}

	@GetMapping("/search/customer/{id}")
	public ResponseEntity<List<ProductDetails>> findProductsWithId(@PathVariable("id") long id) {
		List<ProductDetails> details = service.getAllProductWithId(id);
		return new ResponseEntity<List<ProductDetails>>(details, HttpStatus.FOUND);
	}

	@GetMapping("/customerProducts")
	public ResponseEntity<List<QueryDataResponse>> findProductNameByCustomerId() {
		List<QueryDataResponse> details = service.getProductNametById();
		return new ResponseEntity<List<QueryDataResponse>>(details, HttpStatus.FOUND);
	}

}
