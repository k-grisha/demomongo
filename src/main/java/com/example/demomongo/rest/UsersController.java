package com.example.demomongo.rest;

import com.example.demomongo.entity.User;
import com.example.demomongo.repository.UserRepository;
import java.util.Random;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private Logger logger = Logger.getLogger(UsersController.class);

    @Autowired
    UserRepository userRepository;

    // todo change to POST
    @GetMapping("/user/create/{name}")
    public String createUser(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        user.setAge(new Random().nextInt());
        userRepository.insert(user);
        return "User created " + user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id = " + id + " found"));
    }

}
