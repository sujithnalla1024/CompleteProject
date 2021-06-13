package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderModel;


@Repository
@Transactional
public interface orderrepository extends JpaRepository<OrderModel,String>{

	List<OrderModel> findByUserid(String userid);



}