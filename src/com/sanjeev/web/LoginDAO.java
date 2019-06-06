package com.sanjeev.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	public boolean getUser(String user, String pass) {
		boolean result = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement ps = connection.prepareStatement("select * from user where username= ? and password =?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs =	ps.executeQuery();
		
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
