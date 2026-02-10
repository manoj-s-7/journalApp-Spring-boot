package com.manojs.journalapp.repository;

import com.manojs.journalapp.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,ObjectId> {
    UserEntity findAllByUserName(String userName);
}
