package com.society.backend.service.implementation;

import com.society.backend.entity.User;
import com.society.backend.repository.UserRepository;
import com.society.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public List<User> fetchAllUsers() {
        log.warn("Request >> Fetching all users from database");
        return userRepository.findAll();
    }

    public User fetchUser(Long id) {

        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Answer << User not found!");
        }

        log.warn("Request >> Fetching user by ID = {} from database", id);
        return userRepository.getById(id);
    }

    public User saveUser(User user) {

        if (userRepository.findById(user.getId()).isPresent()) {
            throw new RuntimeException("Answer << User already exists!");
        }

        log.warn("Request >> Saving user {} to database", user.getEmail());
        return userRepository.save(user);
    }

    public Boolean deleteUser(User user) {

        if (userRepository.findById(user.getId()).isEmpty()) {
            throw new RuntimeException("Answer << User not found!");
        }

        log.warn("Request >> Deleting user {} from database", user.getEmail());
        userRepository.delete(user);

        return true;
    }

}