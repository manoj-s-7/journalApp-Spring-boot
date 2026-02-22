package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.User;
import com.manojs.journalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getAllUsers(PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saved = userService.saveUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(Optional.empty() ,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> exists = userService.getUserById(id);
        if (exists.isEmpty()){
            return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        User userByName = userService.findUserByName(userName);
        if (userByName!= null){
            userByName.setUserName(user.getUserName());
            userByName.setPassword(user.getPassword());
            userService.saveUser(userByName);
            return new ResponseEntity<>(userByName,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("Invalid Details");
    }
}
