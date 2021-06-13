package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class ProductController {
    @Autowired
    private ProductService productservice;
   
    @GetMapping("/home")
    public List<ProductModel> allProducts() {
        return productservice.findall();
    }

    @GetMapping("admin/productEdit/{id}")
    public Optional<ProductModel> getUserById(@PathVariable("id") String userId) {
        return productservice.getid(userId);
    }

    @PostMapping("admin/addProduct")
    public ProductModel meth(@RequestBody ProductModel product) {
        return productservice.create(product);
    }

    @PostMapping("admin/productEdit/{id}")
    public void updateproduct(@RequestBody ProductModel product, @PathVariable("id") Long userId) {
        productservice.create(product);
    }

    @PostMapping("admin/delete/{id}")
    public void delete(@PathVariable("id") String userId) {
        productservice.deleteUserById(userId);
    }

    @GetMapping("product/{id}")
    public ProductModel productmodelbyid(@PathVariable("id") String pid)
    {
    	return productservice.productmodelbyid(pid);
    }


}
