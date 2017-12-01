<!--
file name: pro.jsp
author: Kamil Robakowski 16138520
date: 15/11/2017
references:https://www.udemy.com/javawebtut/learn/v4/overvie
comments: This file has been created using materials from online course: Servlets and JSPs Tutorial: Learn Web Applications With Java.
-->
<!-- taglibs to enable JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

	<!-- query database to get all records for logged user using session attribute "name" -->
	<sql:query var="rs" dataSource="jdbc/database1">
select * from data where userName = '<%=session.getAttribute("name")%>' ;
</sql:query>


	<!-- displaying users records -->
	<h2>User Profile</h2>
	<%=session.getAttribute("name")%>
	<div class="center">
		<table class="table">
			<tr>
				<th>userName</th>
				<th>app</th>
				<th>password</th>
			</tr>
			<tr>
				<c:forEach var="row" items="${rs.rows}">
					<tr>
						<td>${row.userName}</td>
						<td>${row.app}</td>
						<td>${row.appPassword}</td>
					</tr>
				</c:forEach>
		</table>

	</div>
	</br>

	<!-- links to another JSP's -->
	<input class="button" type="submit"
		onclick="location.href='/pr11/gener.jsp'"
		value="Generate new password" />
	</br>

	<input class="button" type="submit"
		onclick="location.href='/pr11/deleteRecord.jsp'"
		value="Delete password" />
	</br>

	<input class="button" type="submit"
		onclick="location.href='/pr11/passwordUpdate.jsp'"
		value="Change my password" />
	</br>

	<input class="button" type="submit"
		onclick="location.href='LogoutServlet'" value="Logout" />
	</br> -------------------------------------------------
	</br> session attributes
	</br> psw:
	<%=session.getAttribute("pswo")%>
	</br> user:
	<%=session.getAttribute("name")%>



</body>
</html>