package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class CartModel {

	@Id
	@Column 
	@GeneratedValue
	int cartid;
	@Column
	String productname;
	@Column
	String userid;
	@Column
	String quantity;
	@Column
	String price;
	public CartModel() {}
	public CartModel(String productname, String userid, String quantity, String price) {
		this.productname = productname;
		this.userid = userid;
		this.quantity = quantity;
		this.price = price;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
