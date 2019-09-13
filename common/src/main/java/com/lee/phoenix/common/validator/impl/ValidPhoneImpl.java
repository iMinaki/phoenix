package com.lee.phoenix.common.validator.impl;

import com.lee.phoenix.common.util.ValidatorUtil;
import com.lee.phoenix.common.validator.ValidPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneImpl implements ConstraintValidator<ValidPhone, String> {
    @Override
    public void initialize(ValidPhone validPhone) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return ValidatorUtil.isRealPhone(s);
    }
}