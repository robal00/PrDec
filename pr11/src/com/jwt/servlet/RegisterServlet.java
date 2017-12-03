/*Class name: RegisterServlet.java
 * date: 15/11/2017
 * @reference:  http://www.javawebtutor.com/articles/servlets/servlet_db_example.php
 * @author: Kamil Robakowski 16138520
 * @comments: Parts of code in this class have been reused and sourced from website referenced.
 * author modified:
 * parameters required to connect to database to match development environment requirements
 * messages to be sent in responses
 * prepared statement for query to be executed in database
 * exception handling (redirect to error page instead of printing stack trace)
 * author added:
 * validation of strings n, e and p 
 * code comments 
 * GET method
*/


//http://www.javawebtutor.com/articles/servlets/servlet_db_example.php
package com.jwt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
     // receive strings from form in jsp
        String n = request.getParameter("userName");
        String p = request.getParameter("app");
        String e = request.getParameter("appPassword");
        
     // validate if there are no spaces in strings e,p and n 
        if(p.matches("\\w*\\s+\\w*")){RequestDispatcher rd=request.getRequestDispatcher("generatedPassword.jsp"); 
   	 out.print("space is not allowed, use underscore");
   	 rd.include(request,response); }
        else {
        
        try {
        	
        	//connecting to database
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database1", "dbUser", "zaq1@wsx");
          //prepared statement for query to be executed in database 
            PreparedStatement ps = con
                    .prepareStatement("insert into data(userName,app,appPassword) values (?,?,?)");
 
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e);
            
            //execution of query in database
            int i = ps.executeUpdate();
           
            //if query executed successfully redirect to pro.jsp and display message 
            if (i > 0)
            	out.print("<p style=\"color:green\">password saved</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("pro.jsp");  
            rd.include(request,response);  
 
        } catch (Exception e2) {
        	//if query returns error redirect to error page 
        	RequestDispatcher rd=request.getRequestDispatcher("error.html");  
            rd.include(request,response); 
        }
 
        out.close();
    } 
    }
  //redirect to index.jsp if GET method is called
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		
  		request.getRequestDispatcher("index.jsp").include(request, response);
  	}


	
	
}
