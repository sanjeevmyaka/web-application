<%@page import="com.sanjeev.stdsearch.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
div {
border-radius: 10px 10px 10px 10px;
-moz-border-radius: 10px 10px 10px 10px;
-webkit-border-radius: 10px 10px 10px 10px;
border: 0px solid #000000;
background-color: #e7a61a;
}
</style>
</head>
<body>
<div>

<%
		Student student = (Student) request.getAttribute("studentObject");
	%>

	<%
		if (student != null) {
	%>
	<h3>
		Student Id :
		<%=student.getId()%></h3>
	<h3>
		Student Name :
		<%=student.getName()%></h3>
	<h3>
		Student Age :
		<%=student.getAge()%></h3>
	<h3>
		Student LOCATION :
		<%=student.getLoc()%></h3>
	<%
		} else {
	%>
	<h3>No record found by given Id</h3>
	<%
		}
	%>

</div>
	
</body>
</html>