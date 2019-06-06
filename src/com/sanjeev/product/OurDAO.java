package com.sanjeev.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OurDAO {
	
	public boolean getUser(String user, String password) {
		
		boolean result = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement ps = connection.prepareStatement("select * from user where username= ? and password =?");
			ps.setString(1, user);
			ps.setString(2, password);
			ResultSet rs =	ps.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public List<Product> getProducts(){
		
		List<Product> listProduct = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement ps = connection.prepareStatement("select * from product");
			ResultSet rs =	ps.executeQuery();
			
		
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setCat(rs.getString("cat"));
				product.setAvail(rs.getInt("avail"));
				
				listProduct.add(product);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listProduct;
	}
	
	public void saveProduct(Product product) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement	ps = connection.prepareStatement("insert into product(name,price,cat,avail) values(?,?,?,?)");
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getCat());
			ps.setInt(4, product.getAvail());
			ps.executeUpdate();
			
			ps.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
