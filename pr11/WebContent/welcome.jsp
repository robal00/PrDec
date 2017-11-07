<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
    <h3>Login successful!!!</h3>
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
        
        
         <form>
<input type="button" class="button" value="your profile" onclick="location.href='/pr11/pro.jsp'" />
</form> 
        
</body>
</html>