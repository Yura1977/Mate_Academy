package com.verbitskey.service;

import com.verbitskey.model.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public Optional<User> authorize(User user) {
        user.setFirstName( "Anton" );
        return Optional.of( user );
    }
}
