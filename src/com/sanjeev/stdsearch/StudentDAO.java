package com.sanjeev.stdsearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

	public Student getStudentInfo(int id) {
		
		Student student = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement ps =  connection.prepareStatement("select * from students where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setLoc(rs.getString("loc"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
		
	}
}
