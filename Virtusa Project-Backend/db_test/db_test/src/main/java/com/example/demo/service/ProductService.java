package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  {
    @Autowired
    private ProductRepository productrepository;

    public List<ProductModel> findall() {
        return productrepository.findAll();
    }

    public Optional<ProductModel> getid(String id) {
        return productrepository.findById(id);
    }

    public ProductModel create(ProductModel product) {
        return productrepository.save(product);
    }

    public void deleteUserById(String userId) {
        productrepository.deletebyproductname(userId);
    }

    public ProductModel productmodelbyid(String pid)
    {
    	//return null;
    	return productrepository.findByProductid(pid);
    }
    public ProductModel productmodelbyproductname(String pname)
    {
    	return productrepository.findbyproductname(pname);
    }

    

}