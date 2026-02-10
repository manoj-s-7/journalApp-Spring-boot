package com.manojs.journalapp.controller;

import com.manojs.journalapp.entity.UserEntity;
import com.manojs.journalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping(path = "users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getusers(){
        return ResponseEntity.ok(userService.getAllusers());
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity){
        UserEntity saved = userService.saveUser(userEntity);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable ObjectId id){
        Optional<UserEntity> user = userService.gebytUserId(id);
        if (user.isEmpty()){
            return new ResponseEntity<>(Optional.empty() ,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ObjectId id){
        Optional<UserEntity> exists = userService.gebytUserId(id);
        if (exists.isEmpty()){
            return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
        UserEntity userByName = userService.findUserByName(user.getUserName());
        if (userByName!= null){
            userByName.setUserName(user.getUserName());
            userByName.setPassword(user.getPassword());
            userService.saveUser(userByName);
            return new ResponseEntity<>(userByName,HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("Invalid Details");
    }

}
