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

import com.example.project.DaoImpl.SizeDaoImpl;
import com.example.project.model.Size;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SizeController {
	
	@Autowired
	SizeDaoImpl obj;

	@GetMapping("/cat")
	public List getCustomer() {
		return obj.getSize();
	}

	@RequestMapping(value = "/cat", method = RequestMethod.POST)
	public void addCategory(@RequestBody Size size) {

		obj.addSize(size);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cat/{id}")
	public void deleteCategory(@PathVariable int id) {
		obj.deleteSize(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/cat")
	public void updateCategory(@RequestBody Size size) {
		obj.updateSize(size);
	}
}
