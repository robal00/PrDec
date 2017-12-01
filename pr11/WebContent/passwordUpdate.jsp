<!--
file name: passwordUpdate.html
author: Kamil Robakowski 16138520
date: 15/11/2017
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Password</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
	
	<!-- form to enter new password, entered value is passed to PassUpdate.java using post method -->
	<form action="PassUpdate" method="post">

		Enter new Password </br> <input type="hidden" name="username"
			value="<%=session.getAttribute("name")%>"></br> Password</br> <input
			type="password" name="userpass" required="required" /></br> <input
			class="button" type="submit" value="Update" />

	</form>
</body>
</html>