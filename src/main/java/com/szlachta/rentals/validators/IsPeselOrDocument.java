package com.szlachta.rentals.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsPeselOrDocumentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsPeselOrDocument {
    String message() default "Należy typ dokumentu oraz pesel lub numer dokumentu";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    }
