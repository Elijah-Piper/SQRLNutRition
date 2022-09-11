package com.genspark.SQRLNutRitionAPI.UserConf.Authentication;

import com.genspark.SQRLNutRitionAPI.UserConf.Registration.Dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation)    {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context)  {
        Dto user = (Dto) obj;
        return user.getPassfield1().equals(user.getPassfield2());
    }
}
