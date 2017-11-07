<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
	<form action="loginServlet" method="post">

		user name</br> <input type="text" name="username" required="required" /></br>
		Password</br> <input type="password" name="userpass" required="required" /></br>
		<input class="button" type="submit" value="Login" />

	</form>
	
	-------------------------------------------------</br>
	session attributes
	</br> psw: 	<%=session.getAttribute("pswo")%>
</br> user: 	<%=session.getAttribute("name")%>
	
</body>
</html>