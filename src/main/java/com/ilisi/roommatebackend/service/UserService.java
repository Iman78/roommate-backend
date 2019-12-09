package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import com.ilisi.roommatebackend.model.User;
import com.ilisi.roommatebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends BasicService<User, Integer> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public JpaRepository<User, Integer> getRepository() {
        return userRepository;
    }

    public User findByUsername(String s) {

        Optional<User> user=userRepository.findByUsername(s);
        if(! user.isPresent()) return null;
        return user.get();
    }
}
