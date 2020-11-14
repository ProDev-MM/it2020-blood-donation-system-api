package com.mds.bdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mds.bdms.entity.User;
import com.mds.bdms.service.UserService;

@RestController
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping( value="/user")
    public List<User> getUser(){
        return userService.getUser();

    }

    @PostMapping(value="/user")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping (value="/user/{id}")
    public User getById(@PathVariable Long id)
    {
        return userService.findById(id);
    }

    @PutMapping (value = "/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping(value="/user/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }


}

