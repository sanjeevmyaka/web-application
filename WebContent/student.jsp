<%@page import="com.sanjeev.student.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,td,tr,th{
border: 2px solid red;
border-collapse: collapse;
}
</style>
</head>
<body>

<%
	List<Student> list = (List<Student>) request.getAttribute("studentList");
%>
<table>
<tr>
<th>ID</th><th>NAME</th><th>AGE</th><th>LOCATION</th>
</tr>

<%for(Student std : list ) { %>

<tr>
<td><%=std.getId() %></td>
<td><%=std.getName() %></td>
<td><%=std.getAge() %></td>
<td><%=std.getLoc() %></td>
</tr>
<%} %>
</table>

</body>
</html>