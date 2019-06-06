package com.sanjeev.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String	user = req.getParameter("username");
		String	pass = req.getParameter("password");
		
		LoginDAO loginDAO = new LoginDAO();
		boolean result = loginDAO.getUser(user, pass);
		
		PrintWriter pw = resp.getWriter();
		
		if(result) {
			pw.write("your are login succuss ");
		} else {
			pw.write("Your are login Faid ");
		}
		
		
		
	}
}
