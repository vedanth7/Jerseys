package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Dao.CustomerDao;
import com.example.project.DaoImpl.CustomerDaoImpl;
import com.example.project.model.Customer;
@Repository
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired

	private CustomerDao customerDAO;
//	 @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
//	 public void addTransaction(@RequestBody Customer theTransaction){
//
//	      customerDAO.addCustomer(theTransaction);
//	 }
	 @GetMapping("/customer")
		public List getCustomer()
		{
			return customerDAO.getCustomer();
			
		}
	 @GetMapping("customer/{custUserName}/{custPassword}")
		public int CustomerLogin(@PathVariable("custUserName") String custUserName, @PathVariable("custPassword") String custPassword) {
			
			int flag=customerDAO.loginValidation(custUserName, custPassword);
//			if(flag==0) {
//				return new ResponseEntity("No Customer found for id " +custUserName,HttpStatus.NOT_FOUND);
//			}
//			return new ResponseEntity(custUserName+" Customer found  ", HttpStatus.FOUND);
			
			return flag;
		}

		@RequestMapping(value = "/custAdd", method = RequestMethod.POST)
		public void addCustomer(@RequestBody Customer customer){

			customerDAO.addCustomer(customer);
		}
		
		@RequestMapping(method=RequestMethod.DELETE,value="/cust/{id}")
		public void deleteCustomer(@PathVariable int id) {
			customerDAO.deleteCustomer(id);
		}
//		@RequestMapping(value = "/put/customer/{id}", method = RequestMethod.PUT)
//		public ResponseEntity update(@PathVariable int id, @RequestBody Customer cust) {
//
//		customerDAO.updateCustomer(id,cust);
//		return new ResponseEntity("updated cust" + cust, HttpStatus.ACCEPTED);
//
//		}
		
		@RequestMapping(method=RequestMethod.PUT,value="/cust")
		public void updateCustomer(@RequestBody  Customer customer) {
			customerDAO.updateCustomer(customer);
		}
		
		
		@GetMapping()
		public void changePassword(int custId,String oldPassword, String newPassword)
		{
			customerDAO.updatePassword(oldPassword, newPassword, custId);
		}

}