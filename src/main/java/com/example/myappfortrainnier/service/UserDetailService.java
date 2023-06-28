package com.example.myappfortrainnier.service;

import com.example.myappfortrainnier.entity.UserEntity;
import com.example.myappfortrainnier.repository.UserRepository;
import com.example.myappfortrainnier.sequrity.UsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService{
    private final UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if(userEntity.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }

        return new UsDetails(userEntity.get());
    }
}
