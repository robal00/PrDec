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


<sql:query var="rs" dataSource="jdbc/database1">
select * from data where userName = '<%= session.getAttribute("name") %>' ;
</sql:query>

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

<select>
<c:forEach var="row" items="${rs.rows}">
					
					<option value="${row.app}">${row.app}</option>	
						
				</c:forEach>
</select>


	</div>
</br>
	<input class="button" type="submit"
		onclick="location.href='/pr11/gener.jsp'"
		value="Generate new password" />
	<input class="button" type="submit"
		onclick="location.href='/pr11/updateRecord.jsp'" value="update record" />







</body>
</html>