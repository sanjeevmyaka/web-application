package com.sanjeev.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentDAO studentDAO = new StudentDAO();
		List<Student> StudentList = studentDAO.getStudents();
		
		req.setAttribute("studentList", StudentList);
		RequestDispatcher rd =	req.getRequestDispatcher("/student.jsp");
		rd.forward(req, resp);
	}
}
