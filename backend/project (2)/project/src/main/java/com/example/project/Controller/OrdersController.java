package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DaoImpl.OrdersDaoImpl;
import com.example.project.model.Orders;


@RestController
public class OrdersController {
	@Autowired
	OrdersDaoImpl obj;
	
	@GetMapping("/Orders")
	public List getProducts() {
		return obj.getOrders();
	}

	@RequestMapping(value = "/Orders2", method = RequestMethod.POST)
	public void addProducts(@RequestBody Orders Orders) {

		obj.addOrders(Orders);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/Orders/{id}")
	public void deleteProducts(@PathVariable int id) {
		obj.deleteOrders(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/Orders1")
	public void updateProducts(@RequestBody Orders Orders) {
		obj.updateOrders(Orders);
	}

}
