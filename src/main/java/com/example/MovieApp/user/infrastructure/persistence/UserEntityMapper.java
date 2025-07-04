package com.example.MovieApp.user.infrastructure.persistence;

import com.example.MovieApp.user.domain.Email;
import com.example.MovieApp.user.domain.User;
import com.example.MovieApp.user.domain.UserId;
import com.example.MovieApp.user.domain.Username;

public class UserEntityMapper {

    public static User toDomain(UserEntity entity) {
        return User.restoreFromPersistence(
                new UserId(entity.getId()),
                new Username(entity.getUsername()),
                new Email(entity.getEmail()),
                entity.getPasswordHash(),
                entity.getCreatedAt()
        );
    }


    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId() != null ? user.getId().getValue() : null);
        entity.setUsername(user.getUsername().getValue());
        entity.setEmail(user.getEmail().getValue());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setCreatedAt(user.getCreatedAt());
        return entity;
    }



}

