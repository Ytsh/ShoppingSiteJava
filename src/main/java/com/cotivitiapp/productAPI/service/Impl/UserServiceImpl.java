package com.cotivitiapp.productAPI.service.Impl;

import com.cotivitiapp.productAPI.exception.ResourceNotFoundException;
import com.cotivitiapp.productAPI.model.User;
import com.cotivitiapp.productAPI.repository.UserRepository;
import com.cotivitiapp.productAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User u = this.userRepository.findById(user.getId()).orElseThrow(()->
                new ResourceNotFoundException("User Not Found By id:"+user.getId()));
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setLastName(user.getLastName());
//        u.setRoles(user.getRoles());
//        u.setShoppingCart(user.getShoppingCart());
        this.userRepository.save(u);

        return u;
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return this.userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User Not Found By id:"+userId));
    }

    @Override
    public void deleteUser(Long userId) {
        User u = this.userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User Not Found By id:"+userId));
        this.userRepository.delete(u);
    }
}
