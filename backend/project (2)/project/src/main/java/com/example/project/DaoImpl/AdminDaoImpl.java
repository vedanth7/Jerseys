package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Dao.AdminDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Admin;


@Repository
public class AdminDaoImpl implements AdminDao{
	@Autowired
	static List<Admin> list = new ArrayList();

	Connection connection;

	public AdminDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}

	@Override
	public List<Admin> getAdmin() {
		System.out.println("Inside viewAll Admin");
		try {

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from admin");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				System.out.println("Inside while");
				admin.setAdminId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				System.out.println("Inside while-2");
				list.add(admin);
				System.out.println(list);
			}
		} catch (Exception e) {
			System.out.println("Failed to view in Admin");
			System.out.println(e);
		}
		return list;
	}

	@Override
	public void addAdmin(Admin admin) {
		System.out.println("Inside addAdmin");
		int adminId = admin.getAdminId();
		String adminUserName = admin.getAdminName();
		String adminPass = admin.getAdminPassword();
		String Query = "insert into admin(adminName,adminPassword) values('" + adminUserName + "','" + adminPass + "')";

		try {
			PreparedStatement stmt = connection.prepareStatement(Query);
			stmt.executeUpdate();
			System.out.println("Admin Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("Admin Add FAILED");
		}
		
	}

	@Override
	public void deleteAdmin(int id) {
		System.out.println("Inside deleteAdmin");
		String query = "DELETE FROM admin WHERE adminId='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("admin Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("admin Delete FAILED");
		}
		
	}
	@Override

	public void updateAdmin(Admin admin) {
		System.out.println("Inside updateAdmin");
		int adminId = admin.getAdminId();
		String adminUserName = admin.getAdminName();
		String adminPass = admin.getAdminPassword();

		String Query = "update  admin set adminUserName='" + adminUserName + "',adminPass='" + adminPass + "'where adminId='" + adminId + "'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(Query);
			stmt.executeUpdate();
			System.out.println("Admin update Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("Admin update FAILED");
		}
		
	}

	@Override
	public int loginValidation(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

}
