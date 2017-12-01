<!--
file name: deleteRecord.jsp
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
<title>Delete Record</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

<!-- query database to get all records for logged user using session attribute "name" -->
	<sql:query var="rs" dataSource="jdbc/database1">
select * from data where userName = '<%=session.getAttribute("name")%>' ;
</sql:query>

	
<!-- form to display all records for user, selected value is passed to DeleteRecord.java using post method -->
	<form action="DeleteRecord" method="post">

		<br />
		<input type="hidden" name="userName"
			value=<%=session.getAttribute("name")%>><br /> <br /><p> Delete password for application:</p><br />




		<c:forEach var="row" items="${rs.rows}">

			<input type="radio" name="app" value="${row.app}">${row.app}<br>

		</c:forEach>






		<br /> <br />
		<input type="hidden" name="appPassword"
			value=<%=session.getAttribute("pswo")%>><br /> <input
			class="button" type="submit" value="Delete" />

	</form>






	psw
	<br />
	<%=session.getAttribute("pswo")%>

</body>
</html>