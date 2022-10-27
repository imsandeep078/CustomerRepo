package com.customer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "email", columnNames = { "email" }))
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	/* @NotNull(message = "First name cannot be null") */
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;
	/* @NotNull(message = "Last name cannot be null") */
	@NotEmpty(message = "First name cannot be empty")
	private String lastName;
	/*
	 * @Pattern(regexp = "^\\d{10}$", message =
	 * "Invalid phone no. should be 10 digits")
	 */
	@Min(value = 1000000000, message = "Invalid phone no. should be 10 digits")
	@Max(value = 9999999999l, message = "Invalid phone no. should be 10 digits")
	private long phoneNo;
	@Email(message = "Invalid email address..")
	@Column(name = "email")
	/* @Unique(message = "Email id already exist..") */
	private String email;
	@OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<ProductDetails> productDetails;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", productDetails=" + productDetails + "]";
	}

}
