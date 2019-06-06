package com.sanjeev.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public List<Student> getStudents() {
		
		List<Student> list = new ArrayList<Student>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
			PreparedStatement	ps =connection.prepareStatement("select * from students");
			ResultSet rs =	ps.executeQuery();
			
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				student.setLoc(rs.getString("loc"));
				list.add(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
