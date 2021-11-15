package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DaoImpl.AdminDaoImpl;
import com.example.project.model.Admin;


@RestController
public class AdminController {
	@Autowired
	AdminDaoImpl obj;

	@GetMapping("/admin")
	public List getAdmin() {
		return obj.getAdmin();
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public void addCategory(@RequestBody Admin admin) {

		obj.addAdmin(admin);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/{id}")
	public void deleteCategory(@PathVariable int id) {
		obj.deleteAdmin(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/admin")
	public void updateCategory(@RequestBody Admin admin) {
		obj.updateAdmin(admin);
	}
}


