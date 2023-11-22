package com.cogenio.springbootproject.service;

import com.cogenio.springbootproject.model.User;
import com.cogenio.springbootproject.model.json.UserResponse;
import com.cogenio.springbootproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse.UserInfo> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponse.UserInfo::new)
                .collect(Collectors.toList());
    }


    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userRepository.save(user);

        return user;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public UserResponse.UserUpdateResponse updateUser(Long userId, String newUsername, String newEmail, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Create a copy of the user before the update
            User beforeUpdate = new User(user);

            // Apply the update
            user.setUsername(newUsername);
            user.setEmail(newEmail);
            user.setPassword(newPassword);

            // Save the update
            User afterUpdate = userRepository.save(user);

            return new UserResponse.UserUpdateResponse(HttpStatus.OK, "User updated successfully", beforeUpdate, afterUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }



}