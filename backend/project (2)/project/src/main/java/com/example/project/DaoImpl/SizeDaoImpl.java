package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Dao.SizeDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Size;


@Repository
public class SizeDaoImpl implements SizeDao{
	static List<Size> list = new ArrayList();

	Connection connection;
	
	public SizeDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}

	@Override
	public List<Size> getSize() {
		System.out.println("Inside viewAll Category");
		try {

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from size");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Size size = new Size();
				System.out.println("Inside while");
				size.setSizeid(rs.getInt(1));
				size.setSizename(rs.getString(2));
				size.setSizeprice(rs.getInt(3));
				System.out.println("Inside while-2");
				list.add(size);
				System.out.println(list);
			}
		} catch (Exception e) {
			System.out.println("Failed to view in size");
			System.out.println(e);
		}
		return list;
	}

	@Override
	public void addSize(Size size) {
		System.out.println("Inside addCategory");
		int sizeId = size.getSizeid();
		String sizeName = size.getSizename();
		int sizeprice=size.getSizeprice();
		String Query = "insert into size(sizeName) values('" + sizeName + "','" + sizeprice + "')";

		try {
			PreparedStatement stmt = connection.prepareStatement(Query);
			stmt.executeUpdate();
			System.out.println("size Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("size Add FAILED");
		}

	}

	@Override
	public void deleteSize(int id){
		System.out.println("Inside delete size");
		String query = "DELETE FROM size WHERE sizeid='" + id + "';";

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
	public void updateSize(Size size) {
		System.out.println("Inside updateCategory");
		int sizeId = size.getSizeid();
		String sizeName = size.getSizename();
		int sizeprice=size.getSizeprice();

		String Query = "update  size set sizename='" + sizeName + "'where sizeid='" + sizeId + "'";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(Query);
			stmt.executeUpdate();
			System.out.println("size update Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("size update FAILED");
		}
	}

}
