package com.mds.bdms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mds.bdms.entity.User;
import com.mds.bdms.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();

    }

    public User addUser (User user) {
        return userRepository.save(user);

    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }


}


