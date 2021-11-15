package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Dao.OrdersDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Orderdetails;
import com.example.project.model.Orders;
@Repository
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	static List<Orders> list = new ArrayList();
	
	Connection connection;
	Orders Orders  = new Orders();
	public OrdersDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}

	@Override
	public List<Orders> getOrders() {
		// TODO Auto-generated method stub
		System.out.println("Inside viewAll Orders");
		try {

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from Orders");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				System.out.println("Inside while");
				Orders.setOrderid(rs.getInt(1));
				Orders.setOrder_date(rs.getString(2));
				Orders.setCutomerid(rs.getInt(3));
				Orders.setTotal(rs.getInt(4));
			
				
				
				
				System.out.println("Inside while-2");
				list.add(Orders);
				System.out.println(list);
			}
		} catch (Exception e) {
		}
		return list;
	}
	

	@Override
	public void addOrders(Orders Orders) {
		// TODO Auto-generated method stub
		System.out.println("Inside Orders");
		int orderid=Orders.getOrderid();
		String order_date=Orders.getOrder_date();
		int customerid=Orders.getCutomerid();
		int total=Orders.getTotal();
		
		String SignUpQuery = "insert into Orders(orderid,order_date,customerid,total) "
				+ "values('" + orderid + "','" + order_date + "','" + customerid + "','" + total + "')";
		try {
			PreparedStatement stmt = connection.prepareStatement(SignUpQuery);
			stmt.executeUpdate();
			System.out.println(" Orders Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("Orders Add FAILED");
		}
		
	}

	@Override
	public void deleteOrders(int orderid) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteOrders");
		String query = "DELETE FROM Orders WHERE orderid='" + orderid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Orders Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Orders Delete FAILED");
		}
	}

	@Override
	public void updateOrders(Orders Orders) {
		// TODO Auto-generated method stub
		System.out.println("Inside Orders");
		int orderid=Orders.getOrderid();
		String order_date=Orders.getOrder_date();
		int customerid=Orders.getCutomerid();
		int total=Orders.getTotal();


		String UpdateQuery = "update  orders set order_date='" + order_date + "',customerid='"
				+ customerid + "',total='" + total + "' where orderid='"+orderid+"';";
		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("Orders Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Orders Update Failed");
			System.out.println(e);

		}
	}
		
	}
	


