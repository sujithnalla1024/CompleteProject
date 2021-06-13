package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
	@Autowired
	private UserService userService;
    @PostMapping("/login")
	public boolean allProducts(@RequestBody LoginModel loginModel) {
		return userService.isloginsuccess(loginModel.getEmail(),loginModel.getPassword());
	}
}
