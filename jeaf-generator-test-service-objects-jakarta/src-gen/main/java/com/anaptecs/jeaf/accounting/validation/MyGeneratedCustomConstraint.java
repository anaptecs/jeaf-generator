package com.anaptecs.jeaf.accounting.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { MyCustomConstraintValidator.class, BankConstraintValidator.class })
public @interface MyGeneratedCustomConstraint {
  MyEnum myEnum();

  String message() default "{com.anaptecs.jeaf.accounting.validation.MyGeneratedCustomConstraint.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}