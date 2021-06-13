package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CartModel;
import com.example.demo.model.ProductModel;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class CartController {
	
	@Autowired
	ProductService productservice;

	
	@Autowired
	CartService cartservice;
	@PostMapping("/home/{id}")
	public void additemtocart(@RequestBody ProductModel productdata,@PathVariable("id") String userid)
	{
		cartservice.fromproductmodel(productdata, userid);
	}
	@GetMapping("cart/{id}")
	public List<CartModel> getallcartitems(@PathVariable("id") String userid)
	{
		return cartservice.allcartbyuserid(userid);
	}
	@PostMapping("/addtocart")
	public void additembycartmodel(@RequestBody CartModel cart)
	{
		cartservice.addtocart(cart);
	}
	@GetMapping("/findallcartitems")
	public List<CartModel> allcart()
	{
		return cartservice.allcart();
	}
	@PostMapping("/delete/{id}/{pname}")
	public void delete(@PathVariable("id") String userid,@PathVariable String pname)
	{
		
		cartservice.delete(userid,pname);
	}
	
	@PostMapping("/placeOrder/{id}/{pname}")//for one item directly placing order
	public void oneitemorder(@PathVariable("id") String userid,@PathVariable("pname") String pname)
	{
	       cartservice.addtocartbyproductmodel(productservice.productmodelbyproductname(pname),userid);
	}

}
