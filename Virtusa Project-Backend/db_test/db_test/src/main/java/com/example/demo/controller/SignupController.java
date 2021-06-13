package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public boolean allProducts(@RequestBody UserModel user) {
         if(userService.isUserExists(user.getEmail(),user.getPassword()))
         {
        	 userService.adduser(user);
        	 return true;
         }
         return false;
    }
    @GetMapping("/userid/{id}")
    public String method(@PathVariable("id") String id )
    {
    	return userService.getuseridbyemail(id);
    }

}
