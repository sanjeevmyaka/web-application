package com.sanjeev.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher	rd = req.getRequestDispatcher("/home.html");
		rd.forward(req, resp);
		
//		resp.setContentType("text/html");
//		PrintWriter	pw = resp.getWriter();
//		pw.write("<form action='login'>");
//		pw.write("<h1>Login page </h1>");
//		pw.write("User Name : <input type='text' name='password' /> <br>");
//		pw.write("password  : <input type='password' name='password' /> <br>");
//		pw.write("<input type='submit' value='Login'>");
		
		//pw.write("</form>");
	}
}
