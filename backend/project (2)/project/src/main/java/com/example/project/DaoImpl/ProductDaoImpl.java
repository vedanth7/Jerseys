package com.example.project.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.project.Dao.ProductDao;
import com.example.project.Util.DBUtil;
import com.example.project.model.Product;



@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	static List<Product> list = new ArrayList();
	
	Connection connection;
	
	public ProductDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection" + connection);
	}
	@Override
	public List<Product> getProduct() {
		System.out.println("Inside viewAll Product");
		list.clear();
		try {

			System.out.println("Inside try");
			PreparedStatement stmt = connection.prepareStatement("select * from product");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				System.out.println("Inside while");
				prod.setPid(rs.getInt(1));
				prod.setPname(rs.getString(2));
				
				prod.setDescription(rs.getString(3));
				prod.setSizeid(rs.getInt(4));
				prod.setImage(rs.getString(5));
				System.out.println("Inside while-2");
				list.add(prod);
				System.out.println(list);
			}
		} catch (Exception e) {
		}
		return list;
	}
	@Override
	public void addProduct(Product product) {
		System.out.println("Inside addProduct");
		int ProdId=product.getPid();
		String ProdName=product.getPname();
		
		String description=product.getDescription();
		int SizeId=product.getSizeid();
		String imageloc=product.getImage();
		

		String SignUpQuery = "insert into product(pname,description,sizeid,imageloc) "
				+ "values('" + ProdName + "','" + description + "','" + SizeId + "', '"+imageloc+"')";
		try {
			PreparedStatement stmt = connection.prepareStatement(SignUpQuery);
			stmt.executeUpdate();
			System.out.println("Product Added Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("Product Add FAILED");
		}

		
	}
	@Override
	public void deleteProduct(int id) {
		System.out.println("Inside deleteProduct");
		String query = "DELETE FROM products WHERE pid='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Product Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Product Delete FAILED");
		}
		
	}
	@Override
	public void updateProduct(Product product) {
		System.out.println("Inside updateProduct");
		int ProdId=product.getPid();
		String ProdName=product.getPname();
		
		String description=product.getDescription();
		int SizeId=product.getSizeid();

		String UpdateQuery = "update  products set pname='" + ProdName + "',description='"
				+ description + "',sizeid='" + SizeId + "' where pid='"+ProdId+"';";

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
}
