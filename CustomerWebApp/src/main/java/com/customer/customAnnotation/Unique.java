package com.customer.customAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.customer.validations.UniqueValidator;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = UniqueValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
