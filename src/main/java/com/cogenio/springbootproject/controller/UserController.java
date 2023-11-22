package com.cogenio.springbootproject.controller;

import com.cogenio.springbootproject.model.User;
import com.cogenio.springbootproject.model.json.UserResponse;
import com.cogenio.springbootproject.service.UserService;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserResponse.UserCreateResponse createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user.getUsername(), user.getEmail(), user.getPassword());
            return new UserResponse.UserCreateResponse(HttpStatus.CREATED, "User created successfully", createdUser);
        } catch (Exception e) {
            return new UserResponse.UserCreateResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }

    @DeleteMapping("/users/{userId}")
    public UserResponse.UserDeleteResponse deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return new UserResponse.UserDeleteResponse(HttpStatus.OK, "User deleted successfully");
        } catch (Exception e) {
            return new UserResponse.UserDeleteResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/users/{userId}")
    public UserResponse.UserUpdateResponse updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        try {
            return userService.updateUser(userId, updatedUser.getUsername(), updatedUser.getEmail(), updatedUser.getPassword());

        } catch (Exception e) {
            return new UserResponse.UserUpdateResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null, null);
        }
    }


}
