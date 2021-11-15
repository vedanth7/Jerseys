package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DaoImpl.ProductDaoImpl;
import com.example.project.model.Product;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
	@Autowired
	ProductDaoImpl obj;
	
	@GetMapping("/products")
	public List getProducts() {
		return obj.getProduct();
	}

	@RequestMapping(value = "/prod", method = RequestMethod.POST)
	public void addProducts(@RequestBody Product product) {

		obj.addProduct(product);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/prod/{id}")
	public void deleteProducts(@PathVariable int id) {
		obj.deleteProduct(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/prod")
	public void updateProducts(@RequestBody Product product) {
		obj.updateProduct(product);
	}
}
