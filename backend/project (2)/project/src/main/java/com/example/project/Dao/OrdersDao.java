package com.example.project.Dao;

import java.util.List;

import com.example.project.model.Orderdetails;
import com.example.project.model.Orders;

public interface OrdersDao {
	public List<Orders> getOrders();
	public void addOrders(Orders Orders);
	public void deleteOrders(int id);
	public void updateOrders(Orders Orders);

}
