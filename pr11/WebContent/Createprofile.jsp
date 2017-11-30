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

 <form action="CreateProfile" method="post" >
  
 
 user name</br><input type="text" placeholder="User name" name="username" /></br>
 Password</br><input type="password" placeholder="Password" name="userpass"/></br>
 
 <input type="Submit" class="button" value="Sign up">
 </form>
<p>The password policy is:</p>

    <p>At least 8 chars</p>

    <p>Contains at least one digit</p>

    <p>Contains at least one lower alpha char and one upper alpha char</p>

   <p> Contains at least one char within a set of special chars (@#%$^ etc.)</p>

   <p> Does not contain space, tab, etc.</p>

</body>
</html>