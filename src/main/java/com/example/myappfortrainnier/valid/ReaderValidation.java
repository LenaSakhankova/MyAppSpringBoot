package com.example.myappfortrainnier.valid;

import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.entity.ReaderEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class ReaderValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ReaderEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FIO", "field.required", "FIO is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "field.required", "Phone number is required");

        ReaderDTO readerDTO = (ReaderDTO) target;

        if (readerDTO.getYearOfBirth() <= 0) {
            errors.rejectValue("yearOfBirth", "field.invalid", "Year of birth should be greater than 0");
        }
    }

}
