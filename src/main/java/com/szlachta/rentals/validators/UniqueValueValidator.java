package com.szlachta.rentals.validators;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private Class<?> entityClass;
    private String field;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context){
        if (value == null) {
            return true;
        }

        String jpql = "SELECT COUNT(*) FROM " + entityClass.getSimpleName() + " WHERE " + field + " = :value";
        Long count = em.createQuery(jpql, Long.class).setParameter("value", value).getSingleResult();

        return count == 0;
    }
}
