<%@page import="java.util.ArrayList"%>
<%@page import="com.sanjeev.product.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table,td,th,tr{
	border-collapse: collapse;
	border : 2px solid red;
	}
</style>
</head>
<body>
	<h1>Login successfully</h1>
	<h1>Product Page</h1>
	<%=request.getAttribute("count")%>
	<%
		List<Product> pro = (List<Product>) request.getAttribute("products");
	%>
	<table >
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PRICE</th>
			<th>CAT</th>
			<th>AVAIL</th>
		</tr>

		<%
			for (Product prd : pro) {
		%>
		<tr>
			<td><%=prd.getId()%></td>
			<td><%=prd.getName()%></td>
			<td><%=prd.getPrice()%></td>
			<td><%=prd.getCat()%></td>
			<td><%=prd.getAvail()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="product.jsp">Add product</a>
</body>
</html>