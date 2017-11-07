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
<form action="updateRecord" method="post">
 		
        <br/><input type="text" name="userName" value=<%=session.getAttribute("name")%>><br/>
       
        app:<br/><input type="text" name="app" /><br/>
        appPassword:<br/><input type="text" name="appPassword" value=<%=session.getAttribute("pswo")%>><br/>
        <br/>
        <input  class="button" type="submit" value="Submit"/>
 
    </form>
    
    
psw</br>
<%=session.getAttribute("pswo") %>

</body>
</html>