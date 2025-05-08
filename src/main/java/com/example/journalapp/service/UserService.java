package com.example.journalapp.service;

import com.example.journalapp.entity.User;
import com.example.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(List.of("USER"));
        userRepository.save(user);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void saveAdmin (User admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole(Arrays.asList("USER", "ADMIN"));
        userRepository.save(admin);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
