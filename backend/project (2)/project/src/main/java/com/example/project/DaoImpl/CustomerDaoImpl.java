package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.example.project.Dao.CustomerDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Customer;

@Repository

public class CustomerDaoImpl implements CustomerDao {
	
	Connection connection;
	Customer currentCust = new Customer();
	static List<Customer> List1 = new ArrayList();

	public CustomerDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}

@Override
public List<Customer> getCustomer(){
		System.out.println("Inside viewAll customer");
		List1.clear();
		try {
			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from customer");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer cust = new Customer();
				System.out.println("Inside while");
				cust.setCustid(rs.getInt(1));
				cust.setCustname(rs.getString(2));
				cust.setDOB(rs.getString(3));
				cust.setCustusername(rs.getString(4));
				cust.setPassword(rs.getString(5));
				cust.setCustphone(rs.getString(6));
				cust.setCustemail(rs.getString(7));
				cust.setCustaddress(rs.getString(8));
				System.out.println("Inside while-2");
				List1.add(cust);
				System.out.println(List1);
			}
		} catch (Exception e) {
		}
		return List1;
	}

@Override
public int loginValidation(String username, String password) {
	int flag = 0;
	System.out.println("Inside viewAll customer");

	try {
		PreparedStatement stmt = connection
				.prepareStatement("select * from customer where  custUserName='" + username + "'");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			if (rs.getString(4).equals(username) && rs.getString(5).equals(password)) {

				System.out.println("Inside while");
				currentCust.setCustid(rs.getInt(1));
				currentCust.setCustname(rs.getString(2));
				currentCust.setDOB(rs.getString(3));
				currentCust.setCustusername(rs.getString(4));
				currentCust.setPassword(rs.getString(5));
				currentCust.setCustphone(rs.getString(6));
				currentCust.setCustemail(rs.getString(7));
				currentCust.setCustaddress(rs.getString(8));
				System.out.println("Login Successfully");
				flag = 1;
			} else {
				System.out.println("enter Valid Credentials");
			}
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}

	return flag;
}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		// return theTransaction;

		
		String custname = customer.getCustname();
		String custDOB = customer.getDOB();
		String custusername = customer.getCustname();
		String password = customer.getPassword();
		String custphone = customer.getCustphone();
		String custemail = customer.getCustemail();
		String custaddress = customer.getCustaddress();
		try {

			System.out.println("Inside try");
			String SignUpQuery = "insert into customer(custName,custDob,custUserName,custPassword,custPhone,custEmail,custAddress) "
					+ "values('"+custname + "','" + custDOB + "','" + custusername + "','" + password + "','"
					+ custphone + "','" + custemail + "','" + custaddress + "')";
			PreparedStatement st = connection.prepareStatement(SignUpQuery);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Inside UpdateCustomer");
		int custid = customer.getCustid();
		String custname = customer.getCustname();
		String DOB = customer.getDOB();
		String custusername = customer.getCustname();
		String password = customer.getPassword();
		String custphone = customer.getCustphone();
		String custemail = customer.getCustemail();
		String custaddress = customer.getCustaddress();
		

		String UpdateQuery = "update  customer set custName='" + custname + "',custDob='" + DOB + "',custUserName='"
				+ custusername + "',custPassword='" + password + "',custPhone='" + custphone + "'," + "custEmail='"
				+ custemail + "',custAddress='" + custaddress + "' where custid='" + currentCust.getCustid() + "';";
		System.out.println(UpdateQuery);

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
		
			stmt.executeUpdate();
			System.out.println("Customer Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer Update Failed");
			System.out.println(e);

		}

	}



	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside deleteCustomer");
		String query = "DELETE FROM customer WHERE custId='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Customer Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Customer Delete FAILED");
		}

	}
	
	
	
	@Override
	public boolean updatePassword(String oldpassword,String newpassword,int id)
	{
		String password=null;
		String retriveQuerry ="select CustPassword from customer where CustId="+id+"";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(retriveQuerry);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				password=rs.getString(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (password.equals(oldpassword))
		{
			String updateQuerry ="update customer set CustPassword ='"+newpassword+"' where CustId="+id+"";
			try {
				Statement stmt=connection.createStatement();
				stmt.executeUpdate(updateQuerry);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		return true;
	}

}
