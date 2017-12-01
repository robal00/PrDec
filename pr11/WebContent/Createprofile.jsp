<!--
file name: Createprofile.jsp
author: Kamil Robakowski 16138520
date: 15/11/2017
references:https://www.udemy.com/javawebtut/learn/v4/overvie
comments: This file has been created using materials from online course: Servlets and JSPs Tutorial: Learn Web Applications With Java.
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create new user</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

	<!-- form to enter user name and password, values are sent to CreateProfile.java using post method -->
	<form action="CreateProfile" method="post">


		user name</br> <input type="text" placeholder="User name" name="username" /></br>
		Password</br> <input type="password" placeholder="Password" name="userpass" /></br>
		<input type="Submit" class="button" value="Sign up">
	</form>
	<!-- display password policy -->
	<p>The password policy is:</p>

	<p>At least 8 characters</p>

	<p>Contains at least one digit</p>

	<p>Contains at least one lower case and one upper case character</p>

	<p>Contains at least one char within a set of special characters:
		@#$%^&+=!</p>

	<p>Does not contain space, tab, etc.</p>

</body>
</html>