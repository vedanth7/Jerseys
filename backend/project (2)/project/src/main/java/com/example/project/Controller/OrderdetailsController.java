package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DaoImpl.OrderdetailsDaoImpl;
import com.example.project.model.Orderdetails;

@RestController

public class OrderdetailsController {
	@Autowired
	OrderdetailsDaoImpl obj;
	
	@GetMapping("/orderdetails")
	public List getProducts() {
		return obj.getOrderdetails();
	}

	@RequestMapping(value = "/orderdetails2", method = RequestMethod.POST)
	public void addProducts(@RequestBody Orderdetails Orderdetails) {

		obj.addOrderdetails(Orderdetails);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/orderdetails/{id}")
	public void deleteProducts(@PathVariable int id) {
		obj.deleteOrderdetails(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/orderdetails1")
	public void updateProducts(@RequestBody Orderdetails Orderdetails) {
		obj.updateOrderdetails(Orderdetails);
	}

}
