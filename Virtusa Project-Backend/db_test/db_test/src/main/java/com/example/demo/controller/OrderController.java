package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CartModel;
import com.example.demo.model.OrderModel;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class OrderController{
	@Autowired
	OrderService orderservice;
	@Autowired
	CartService cartservice;
	@PostMapping("/placeOrder/{id}")
	public void addallcarttoorders(@PathVariable("id") String userid)
	{
	    List<CartModel> temp=cartservice.allcartbyuserid(userid);	
	orderservice.placeorder(temp,userid);	
	}
    @GetMapping("/orders/{id}")
    public List<OrderModel> orderbyuserid(@PathVariable("id") String userid)
    {
    	return orderservice.getallordersbyuserid(userid);
    }
    
    @GetMapping("admin/getallorders")
    public List<OrderModel> allordersforadmin()
    {
    	return orderservice.allordersforadmin();
    }

}


