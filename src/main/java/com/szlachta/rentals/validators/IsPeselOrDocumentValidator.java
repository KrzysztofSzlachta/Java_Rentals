package com.szlachta.rentals.validators;

import com.szlachta.rentals.dto.PersonRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsPeselOrDocumentValidator implements ConstraintValidator<IsPeselOrDocument, PersonRequest> {

    @Override
    public boolean isValid(PersonRequest personRequest, ConstraintValidatorContext context) {
        boolean hasPesel = personRequest.getPesel() != null && !personRequest.getPesel().isBlank();
        boolean hasDocumentNumber = personRequest.getDocumentNumber() != null && !personRequest.getDocumentNumber().isBlank();
        boolean hasDocumentType = personRequest.getDocumentType() != null && !personRequest.getDocumentType().isBlank();

        return hasDocumentType && (hasDocumentNumber || hasPesel);
    }
}
