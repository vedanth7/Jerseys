package com.example.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.Product;



@Repository
public interface ProductDao {
	public List<Product> getProduct();
	public void addProduct(Product product);
	public void deleteProduct(int id);
	public void updateProduct(Product product);
}
