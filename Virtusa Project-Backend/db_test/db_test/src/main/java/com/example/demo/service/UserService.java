package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.userrepository;
@Service
public class UserService {
@Autowired
userrepository UserRepository;
public boolean adduser(UserModel user)
{
	UserModel temp=UserRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
	if(temp==null) {
	UserRepository.save(user);
	return true;
	}
	return false;
}
public String getuseridbyemail(String email)
{
 UserModel l=UserRepository.findByEmail(email);
 return l.getUserId();
}
public boolean isUserExists(String email,String pass)
{
	UserModel l=UserRepository.findByEmailAndPassword(email,pass);
	return l==null;
}
public boolean isloginsuccess(String email,String pass)
{
	UserModel l=UserRepository.findByEmailAndPassword(email,pass);
	return l!=null;
}


}
