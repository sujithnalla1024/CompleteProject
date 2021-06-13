package com.example.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ProductModel;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductModel,String>{
	@Query(value="select * from app_products where product_id=?1",nativeQuery=true)
	ProductModel findByProductid(String pid);
	
	@Modifying
	@Query(value="delete from app_products where product_name=?1",nativeQuery=true)
	void deletebyproductname(String productname);
	
	@Query(value="select * from app_products where product_name=?1",nativeQuery=true)
	ProductModel findbyproductname(String pid);


}
