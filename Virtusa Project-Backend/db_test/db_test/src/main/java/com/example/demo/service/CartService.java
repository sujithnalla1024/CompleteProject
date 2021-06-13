package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartModel;
import com.example.demo.model.OrderModel;
import com.example.demo.model.ProductModel;
import com.example.demo.repository.cartrepository;
import com.example.demo.repository.orderrepository;
@Service
public class CartService {
	@Autowired
	cartrepository cartRepository;
	@Autowired
	orderrepository orderrepo;

	
	
	public void addtocart(CartModel cartmodel) {
	cartRepository.save(cartmodel);
	}
	public List<CartModel> allcartitems(){
		return cartRepository.findAll();
	}
	public void fromproductmodel(ProductModel productdata,String userid)
	{
            CartModel cart=new CartModel();
            cart.setPrice(productdata.getPrice());
            cart.setProductname(productdata.getProductName());
            cart.setQuantity(productdata.getQuantity());
            cart.setUserid(userid);
            this.addtocart(cart);
	}
	public List<CartModel> allcartbyuserid(String userid)
	{
		return cartRepository.findByUserid(userid);
	}
	public List<CartModel> allcart(){
		return cartRepository.findAll();
	}
	public void delete(String userid,String pname)
	{
		
		cartRepository.deleteByProductname(userid,pname);
	}
	public void deleteall(String userid)
	{
		cartRepository.deletebyuserid(userid);
	}

	public void addtocartbyproductmodel(ProductModel pmodel,String userid){
		 OrderModel temp=new OrderModel();
		 temp.setPrice(pmodel.getPrice());
		 temp.setQuantity("1");
		 temp.setTotalprice(Integer.toString(Integer.parseInt(pmodel.getPrice())*Integer.parseInt(pmodel.getQuantity())));
		 temp.setUserid(userid);
		 temp.setProductname(pmodel.getProductName());
		 orderrepo.save(temp);
		}

}
