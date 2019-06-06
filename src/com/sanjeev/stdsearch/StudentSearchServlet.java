package com.sanjeev.stdsearch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDAO studentDAO = new StudentDAO();
		Student studentObj = studentDAO.getStudentInfo(id);
		
		req.setAttribute("studentObject", studentObj);
		req.getRequestDispatcher("/studentInfo.jsp").forward(req, resp);
	}
}
