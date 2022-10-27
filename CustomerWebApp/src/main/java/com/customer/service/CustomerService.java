package com.customer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.customer.customExceptions.CustomerNotFoundException;
import com.customer.customExceptions.IdNotFoundException;
import com.customer.customExceptions.UnableToPersistException;
import com.customer.dto.QueryDataResponse;
import com.customer.entity.CustomerDetails;
import com.customer.entity.ProductDetails;
import com.customer.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public CustomerDetails saveCustomer(CustomerDetails customerDetails) {
		try {
			repository.save(customerDetails);
		} catch (DataIntegrityViolationException e) {
			System.out.println(e.getRootCause().getMessage());
			if (e.getRootCause().getMessage().contains("Duplicate entry")) {
				throw new UnableToPersistException(e.getRootCause().getMessage());
			} else {
				throw new UnableToPersistException(e.getRootCause().getMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnableToPersistException("Unable to save data.." + e.getMessage());
		}
		String email = customerDetails.getEmail();
		return Optional.ofNullable(repository.findByEmail(email))
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with email :" + email));
	}

	public List<CustomerDetails> searchWithLastName(String lastName) {
		Optional<List<CustomerDetails>> customerDetails = Optional.ofNullable(repository.findByLastName(lastName));
		return customerDetails
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found with last name :" + lastName));
	}

	public List<CustomerDetails> listOfCustomerDetails() {
		return (List<CustomerDetails>) Optional.ofNullable(repository.findAll())
				.orElseThrow(() -> new CustomerNotFoundException("No Records Avialable.."));
	}

	public boolean deleteCustomer(long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else {
			throw new IdNotFoundException("Customer with id " + id + " not found..");
		}
	}

	public List<String> getProductWithId(long id) {
		return Optional.ofNullable(repository.getProducts(id))
				.orElseThrow(() -> new IdNotFoundException("Id not exists in Database..!!"));
	}

	public List<ProductDetails> getAllProductWithId(long id) {
		return Optional.ofNullable(repository.getAllProducts(id))
				.orElseThrow(() -> new IdNotFoundException("Id not found..!!"));
	}

	public Optional<CustomerDetails> getCustomer(long id) {
		return Optional.ofNullable(repository.findById(id))
				.orElseThrow(() -> new IdNotFoundException("user not found..!!"));
	}

	public boolean updateCustomer(CustomerDetails details, long id) {

		try {
			Optional<CustomerDetails> custData = repository.findById(id);
			if (custData.isPresent()) {
				/*
				 * CustomerDetails customerDetails = custData.get();
				 * customerDetails.setFirstName(details.getFirstName());
				 * customerDetails.setLastName(details.getLastName());
				 * customerDetails.setEmail(details.getEmail());
				 * customerDetails.setPhoneNo(details.getPhoneNo());
				 * repository.save(customerDetails);
				 */

				String firstName = details.getFirstName();
				String lastName = details.getLastName();
				String email = details.getEmail();
				long phoneNo = details.getPhoneNo();
				repository.updateById(firstName, lastName, email, phoneNo, id);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<QueryDataResponse> getProductNametById() {
		List<QueryDataResponse> productNameById = null;
		try {
			productNameById = repository.getProductNameById();
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
		}
		return productNameById;
	}

}
