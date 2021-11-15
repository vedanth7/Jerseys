package com.example.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.Customer;


@Repository
public interface CustomerDao {
	public int loginValidation(String username,String password);
	public void addCustomer( Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> getCustomer();
	public void deleteCustomer(int customer);
	public boolean updatePassword(String oldpassword,String newpassword,int id);
//	 public Customer updateCustomer(int id, Customer cust); //update
}
