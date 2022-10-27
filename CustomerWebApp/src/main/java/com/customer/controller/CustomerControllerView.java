package com.customer.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.customer.entity.CustomerDetails;
import com.customer.entity.ProductDetails;
import com.customer.service.CustomerService;

@RestController
public class CustomerControllerView {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerService service;

	private String responseMessage;

	@GetMapping("/home")
	public ModelAndView homePage() {
		System.out.println("homepage() called!!");
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("title", "Home Page");
		mav.addObject("titleIcon", "images/home.jpg");
		return mav;
	}

	@GetMapping("/add_customer")
	public ModelAndView addCustomerForm() {
		System.out.println("addCustomerForm() called!!");
		ModelAndView mav = new ModelAndView("new_customer");
		mav.addObject("customer", new CustomerDetails());
		mav.addObject("titleIcon", "images/add-user.jpg");
		return mav;
	}

	@PostMapping("/save_customer")
	public ResponseEntity<?> addCustomer(@Valid @ModelAttribute("customer") CustomerDetails details) {
		System.out.println("addCustomer() called!!");
		logger.info("Cutsomer details: {}", details);
		CustomerDetails result = service.saveCustomer(details);
		responseMessage = "Added successfully..and customer id is " + result.getCustomerId();
		return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
	}

	@GetMapping("/searchView")
	public ModelAndView searchByLastName(@RequestParam String lastName) {
		List<CustomerDetails> result = service.searchWithLastName(lastName);
		logger.info("Searched User details: {}", result);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("title", "Search Result");
		mav.addObject("customers", result);
		mav.addObject("search", true);
		mav.addObject("titleIcon", "images/customers.jpg");
		return mav;
	}

	@GetMapping("/getAllView")
	/* @RequestMapping("/getAllView") */
	public ModelAndView getAllCustomers() {
		List<CustomerDetails> custList = (List<CustomerDetails>) service.listOfCustomerDetails();
		StringBuilder builder = new StringBuilder();
		custList.stream().forEach(value -> value.getProductDetails().stream().forEach(prod -> {
			builder.append(prod.getModelNo() + ",");
		}));
		System.out.println("Product Models " + builder);

		ModelAndView mav = new ModelAndView("customerData");
		mav.addObject("title", "Customer Data");
		mav.addObject("listOfCustomers", custList);
		mav.addObject("search", true);
		mav.addObject("titleIcon", "images/customers.jpg");
		return mav;
	}

	// Deleting the user

	@RequestMapping("/delete/customer/{id}")
	public ModelAndView removeCustomer(@PathVariable("id") long id) {
		System.out.println("removeCustomer() called...");
		Boolean isSuccess = service.deleteCustomer(id);
		System.out.println(responseMessage);
		ModelAndView mav = new ModelAndView("redirect:/getAllView");
		mav.addObject("isSuccess", isSuccess);
		if (isSuccess) {
			responseMessage = "Id " + id + " has been removed from DB successfully!!";
			System.out.println("message " + responseMessage);
			mav.addObject("message", responseMessage);
		} else {
			responseMessage = "Data not deleted correctlly!!";
			System.out.println("message " + responseMessage);
			mav.addObject("message", responseMessage);
		}
		return mav;
	}

	@GetMapping("/searchView/customer/{id}")
	public ModelAndView findProductsWithId(@PathVariable("id") long id) {
		List<ProductDetails> prodDetails = service.getAllProductWithId(id);
		ModelAndView mav = new ModelAndView("productData");
		mav.addObject("listOfProducts", prodDetails);
		mav.addObject("title", "Products Data");
		mav.addObject("titleIcon", "images/product.jpg");
		return mav;
	}

	@GetMapping("/edit_customer/{id}")
	public ModelAndView updateCustomerForm(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Optional<CustomerDetails> customer = service.getCustomer(id);
		mav.addObject("customer", customer.get());
		mav.addObject("titleIcon", "images/edit.jpg");
		return mav;
	}

	// Updating the user

	@PostMapping("/save")
	/* @RequestMapping("/save") */
	public ModelAndView updateCustomerData(@Valid @ModelAttribute("customer") CustomerDetails details,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("error " + result);
			ModelAndView mav = new ModelAndView("edit_customer");
			return mav;
		}
		boolean isSuccess = service.updateCustomer(details, details.getCustomerId());
		ModelAndView mav = new ModelAndView("redirect:/getAllView");
		mav.addObject("isSuccess", isSuccess);
		if (isSuccess) {
			responseMessage = "Data is updated Successfully!!";
			System.out.println("message " + responseMessage);
			mav.addObject("message", responseMessage);
		} else {
			responseMessage = "Data not updated correctlly!!";
			System.out.println("message " + responseMessage);
			mav.addObject("message", responseMessage);
		}

		return mav;
	}

}
