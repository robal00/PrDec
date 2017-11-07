<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
	</br>
	<input class="button" type="submit"
		onclick="location.href='/pr11/login.jsp'"
		value="Login" />
	
	<input class="button" type="submit"
		onclick="location.href='/pr11/Createprofile.jsp'"
		value="Create new user" />
	
	
	</form>
	
	
	</br>-------------------------------------------------</br>
	session attributes
	</br> psw: 	<%=session.getAttribute("pswo")%>
</br> user: 	<%=session.getAttribute("name")%>
	
</body>
</html>