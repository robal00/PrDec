<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>saving password</title>
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