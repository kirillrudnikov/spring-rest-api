package com.society.backend.controller;

import com.society.backend.entity.User;
import com.society.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RestApiController {

    private final UserService userService;

    // Fetch all Users from DB
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> fetchAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchAllUsers());
    }

    // Fetch User from DB by ID
    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> fetchUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.fetchUser(id));
    }

    // Save User to DB
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(userService.saveUser(user));
    }

    // Delete User from DB
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userService.fetchUser(id)));
    }

}