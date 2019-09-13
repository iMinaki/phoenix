package com.lee.phoenix.common.validator.impl;

import com.lee.phoenix.common.validator.ValidTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTimeImpl implements ConstraintValidator<ValidTime, String> {
    @Override
    public void initialize(ValidTime validTime) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}