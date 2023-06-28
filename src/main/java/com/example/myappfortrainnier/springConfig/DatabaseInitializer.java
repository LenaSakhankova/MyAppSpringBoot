package com.example.myappfortrainnier.springConfig;

import com.example.myappfortrainnier.entity.UserEntity;
import com.example.myappfortrainnier.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseInitializer implements InitializingBean {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void afterPropertiesSet() {
        if (userRepository.count() == 0) {
            createUsersData();
        }
    }

    private void createUsersData() {
        UserEntity user1 = new UserEntity();
        user1.setUsername("user1");
        user1.setYearOfBirth(1990);
        user1.setPassword(passwordEncoder.encode("password1"));
        user1.setRole("ROLE_USER");

        UserEntity user2 = new UserEntity();
        user2.setUsername("user2");
        user2.setYearOfBirth(1985);
        user2.setPassword(passwordEncoder.encode("password2"));
        user2.setRole("ROLE_USER");

        UserEntity admin = new UserEntity();
        admin.setUsername("admin");
        admin.setYearOfBirth(1980);
        admin.setPassword(passwordEncoder.encode("password3"));
        admin.setRole("ROLE_ADMIN");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(admin);
    }
}