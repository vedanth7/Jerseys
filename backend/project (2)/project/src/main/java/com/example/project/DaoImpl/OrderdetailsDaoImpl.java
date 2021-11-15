package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Dao.OrderdetailsDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Orderdetails;
import com.example.project.model.Product;
@Repository
public class OrderdetailsDaoImpl implements OrderdetailsDao {
	@Autowired
	static List<Orderdetails> list = new ArrayList();
	
	Connection connection;
	Orderdetails orderdetails  = new Orderdetails();
	public OrderdetailsDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}

	@Override
	public List<Orderdetails> getOrderdetails() {
		System.out.println("Inside viewAll OrderdetailsDao");
		try {

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from orderdetails");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				System.out.println("Inside while");
				orderdetails.setOrderid(rs.getInt(1));
				orderdetails.setPid(rs.getInt(2));
				orderdetails.setSizid(rs.getInt(3));
				orderdetails.setSizprice(rs.getInt(4));
				
				
				orderdetails.setQty(rs.getInt(5));
				orderdetails.setSum(rs.getInt(6));
				
				System.out.println("Inside while-2");
				list.add(orderdetails);
				System.out.println(list);
			}
		} catch (Exception e) {
		}
		return list;
	}
	

	@Override
	public void addOrderdetails(Orderdetails Orderdetails) {
		// TODO Auto-generated method stub
		System.out.println("Inside addOrderdetails");
		int orderid=orderdetails.getOrderid();
		int pid=orderdetails.getPid();
		int SizeId=orderdetails.getSizid();
		int sizeprice=orderdetails.getSizprice();
		int qty=orderdetails.getQty();
		int sum=orderdetails.getSum();
		
		
		

		String SignUpQuery = "insert into orderdetails(orderid,pid,sizid,sizprice,qty,sum) "
				+ "values('" + orderid + "','" + pid + "','" + SizeId + "','" + sizeprice + "','" + qty + "','" + sum + "')";
		try {
			PreparedStatement stmt = connection.prepareStatement(SignUpQuery);
			stmt.executeUpdate();
			System.out.println(" orderdetails Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("orderdetails Add FAILED");
		}

		
	}
		
	

	@Override
	public void deleteOrderdetails(int orderid) {
		// TODO Auto-generated method stub
		System.out.println("Inside deleteProduct");
		String query = "DELETE FROM orderdetails WHERE orderid='" + orderid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("orderdetails Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("orderdetails Delete FAILED");
		}
		
	}
		
	

	@Override
	public void updateOrderdetails(Orderdetails Orderdetails) {
		// TODO Auto-generated method stub
		System.out.println("Inside addOrderdetails");
		int orderid=orderdetails.getOrderid();
		int pid=orderdetails.getPid();
		int SizeId=orderdetails.getSizid();
		int sizeprice=orderdetails.getSizprice();
		int qty=orderdetails.getQty();
		int sum=orderdetails.getSum();


		String UpdateQuery = "update  orderdetails set pid='" + pid + "',SizeId='"
				+ SizeId + "',sizeprice='" + sizeprice + "',qty='" + qty + "',sum='" + sum + "' where orderid='"+orderid+"';";
		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("orderdetails Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("orderdetails Update Failed");
			System.out.println(e);

		}
	}

}
