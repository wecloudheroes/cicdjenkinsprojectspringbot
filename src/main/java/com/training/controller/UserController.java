package com.training.controller;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.User;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private static final User USER_1 = new User(1L, "Peter", Arrays.asList("peter"), 26, "peter@xyz.com");
    private static final User USER_2 = new User(2L, "John", Arrays.asList("jonny"), 26, "john@xyz.com");

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long userId) throws Exception {
        LOG.info("Find user by id: {}", userId);
        if (userId.equals(1L)) {
            return USER_2;
        } else if (userId.equals(2L)) {
            return USER_1;
        } else {
            throw new Exception("I just created 1 user to test!");
        }
    }

}
