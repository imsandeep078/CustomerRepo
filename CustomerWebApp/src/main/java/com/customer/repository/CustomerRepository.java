package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.customer.dto.QueryDataResponse;
import com.customer.entity.CustomerDetails;
import com.customer.entity.ProductDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long> {

	@Query("SELECT c FROM CustomerDetails AS c WHERE c.lastName=:lastName")
	public List<CustomerDetails> findByLastName(String lastName);

	public CustomerDetails findByEmail(String email);

	public boolean existsByEmail(String email);

	@Query("SELECT p.productName FROM ProductDetails p JOIN p.customerDetails c WHERE c.customerId=:id")
	public List<String> getProducts(@Param("id") long id);

	@Query("SELECT p FROM ProductDetails p JOIN p.customerDetails c WHERE c.customerId=:id")
	public List<ProductDetails> getAllProducts(@Param("id") long id);

	@Modifying
	@Query("UPDATE CustomerDetails c SET c.firstName=:firstName, c.lastName=:lastName, c.email=:email, c.phoneNo=:phoneNo WHERE c.customerId=:Id")
	public void updateById(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("email") String email, @Param("phoneNo") long phoneNo, @Param("Id") long customerId);

	@Query("SELECT new com.customer.dto.QueryDataResponse(c.customerId, p.productName) FROM CustomerDetails c JOIN c.productDetails p")
	public List<QueryDataResponse> getProductNameById();

}