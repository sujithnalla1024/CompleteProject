package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;
@Repository
public interface userrepository extends JpaRepository<UserModel, String>{
	 UserModel findByEmailAndPassword(String username, String password);
	    UserModel findByEmail(String temp);

}
