package com.example.myappfortrainnier.service;

import com.example.myappfortrainnier.entity.UserEntity;
import com.example.myappfortrainnier.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
        private final UserRepository userRepository;

        @Transactional(readOnly = true)
        public List<UserEntity> receiveAllPeople(){
            return userRepository.findAll();
        }


        @Transactional(readOnly = true)
        public boolean checkIfContainsUsername(String username){
            return userRepository.findByUsername(username).isPresent();
        }
}
