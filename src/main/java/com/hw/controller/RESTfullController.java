package com.hw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hw.model.User;

@RestController
public class RESTfullController {

    @RequestMapping(value = "/restfull", produces = "application/xml")
    public User getUser(@RequestParam(value="name", defaultValue="World") String name) {
        User user = new User();
        user.setUserName(name);
        return user;
    }

    @RequestMapping("/restfull")
    public ResponseEntity<String> setUser(@RequestBody User user) {
        return  new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }
}
