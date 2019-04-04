package com.verbitskey.service;

import com.verbitskey.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> authorize(User user);
}
