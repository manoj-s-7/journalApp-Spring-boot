package com.manojs.journalapp.service;

import com.manojs.journalapp.entity.User;
import com.manojs.journalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteUser(Long id) {

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            return false;
        }

        userRepository.delete(user.get());
        return true;
    }

    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
}