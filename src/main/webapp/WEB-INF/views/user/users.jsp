<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="rs.engineering.javacourse.springMvcConfiguration02.dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
	This is user.jsp
	
	
	<%for(User user:(List<User>)request.getAttribute("list")) {%>
	
		<p><%=user.toString() %></p>
	
	<%} %>
	
	
	<a href="/springMvcConfiguration02/user/add">Add user</a>
	${action}
</body>
</html>