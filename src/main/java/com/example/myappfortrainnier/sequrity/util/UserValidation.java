package com.example.myappfortrainnier.sequrity.util;

import com.example.myappfortrainnier.entity.UserEntity;
import com.example.myappfortrainnier.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    private final UserService userService;

    public UserValidation(UserService personService) {
            this.userService = personService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return UserEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserEntity userEntity = (UserEntity) target;

        if(userService.checkIfContainsUsername(userEntity.getUsername())){
            errors.rejectValue("username", "", "This username already exist");
        }
    }
}
