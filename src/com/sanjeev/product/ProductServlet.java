package com.sanjeev.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String password = req.getParameter("password");
		
		OurDAO ourDAO = new OurDAO();
		boolean result = ourDAO.getUser(user, password);
		
		if(result) {
			RequestDispatcher rd = req.getRequestDispatcher("/productDisplay.jsp");
			List<Product>	productList = ourDAO.getProducts();
			
			req.setAttribute("products", productList);
			req.setAttribute("count", productList.size());
			rd.forward(req, resp);
			
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/");
			rd.forward(req, resp);
	}
}
}