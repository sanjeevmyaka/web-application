package com.sanjeev.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductSaveServalet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		String cat = req.getParameter("cat");
		int avail = Integer.parseInt(req.getParameter("avail"));
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setAvail(avail);
		product.setCat(cat);
		
		OurDAO ourDAO = new OurDAO();
		ourDAO.saveProduct(product);
		
		List<Product>	productList = ourDAO.getProducts();
		
		req.setAttribute("products", productList);
		req.setAttribute("count", productList.size());
		
		RequestDispatcher rd = req.getRequestDispatcher("/productDisplay.jsp");
		rd.forward(req, resp);
	}
}
