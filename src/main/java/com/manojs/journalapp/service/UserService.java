package com.manojs.journalapp.service;


import com.manojs.journalapp.entity.UserEntity;
import com.manojs.journalapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity){
        UserEntity saved = userRepository.save(userEntity);
        return saved;
    }

    public List<UserEntity> getAllusers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> gebytUserId(ObjectId id){
        return userRepository.findById(id);
    }

    public boolean deleteUser(ObjectId id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserEntity findUserByName(String userNaem){
        UserEntity userDb = userRepository.findAllByUserName(userNaem);
        return userDb;
    }

}
