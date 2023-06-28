package com.example.myappfortrainnier.valid;

import com.example.myappfortrainnier.dto.LibrarianDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LibrarianValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return LibrarianDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FIO", "field.required", "FIO is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "field.required", "Phone number is required");

        LibrarianDTO librarianDTO = (LibrarianDTO) target;

        if (librarianDTO.getYearOfBirth() <= 0) {
            errors.rejectValue("yearOfBirth", "field.invalid", "Year of birth should be greater than 0");
        }
    }

}
