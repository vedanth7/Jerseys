package com.example.project.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.project.model.Orderdetails;
import com.example.project.model.Product;
@Repository
public interface OrderdetailsDao {
	public List<Orderdetails> getOrderdetails();
	public void addOrderdetails(Orderdetails Orderdetails);
	public void deleteOrderdetails(int id);
	public void updateOrderdetails(Orderdetails Orderdetails);

}
