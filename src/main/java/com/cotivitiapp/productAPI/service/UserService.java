package com.cotivitiapp.productAPI.service;


import com.cotivitiapp.productAPI.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUser();
    User getUserById(Long userId);
    void deleteUser(Long userId);
}
