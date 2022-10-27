package com.customer.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.customer.customAnnotation.Unique;
import com.customer.repository.CustomerRepository;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void initialize(Unique unique) {
		unique.message();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (repository != null && repository.existsByEmail(email)) {
			return false;
		}
		return true;
	}

}
