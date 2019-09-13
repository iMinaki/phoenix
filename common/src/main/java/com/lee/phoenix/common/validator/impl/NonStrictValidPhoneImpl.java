package com.lee.phoenix.common.validator.impl;

import com.lee.phoenix.common.util.ValidatorUtil;
import com.lee.phoenix.common.validator.NonStrictValidPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NonStrictValidPhoneImpl implements ConstraintValidator<NonStrictValidPhone, String> {
    @Override
    public void initialize(NonStrictValidPhone validPhone) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return ValidatorUtil.validPhone(s);
    }
}