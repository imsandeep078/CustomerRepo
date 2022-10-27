package com.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.customer.entity.ProductDetails;

public interface ProductRepository extends CrudRepository<ProductDetails, Long> {

}
