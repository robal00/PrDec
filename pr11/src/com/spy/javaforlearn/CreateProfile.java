package com.spy.javaforlearn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateProfile extends HttpServlet 
{
    @Override
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response)
			              throws ServletException, IOException 
			              
	{
	       response.setContentType("text/html");
		   
	       PrintWriter out=response.getWriter();
		
	       String n=request.getParameter("username");  
	       String p=request.getParameter("userpass"); 
	       
	       
	    Connection con = null;
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		try 
		{
		   //1. Load the Driver
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		  //2. Get the DB Connection via Driver
		 String dbUrl = "jdbc:mysql://localhost:3306/database1?user=root&password=kamilr00";
		 con = DriverManager.getConnection(dbUrl);
			
			
		 //3. Issue SQL Queries via Connection
		 String query = "insert into users values(?,?) ";
			
			
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,n);
		pstmt.setString(2,p);	
		int count = pstmt.executeUpdate();
		
		if(count>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  	
		  out.print("Thanks for Sign up, Your profile successfully created");	
		  rd.include(request,response);  		
		}
	     }
	           
	     catch(Exception e)  
		 {
	    	 RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); 
	    	 out.print("Something goes wrong, Please try again");
	    	 rd.include(request,response);  	 
		 }
		
		finally
		{
			//5. Close all JDBC Objects
			try 
			{
			   if(con != null)
                                {
			        con.close();
				}
			if(pstmt != null)
                                {
				   pstmt.close();
				}
			if(rs != null)
                                {
				  rs.close();
				}
			 } 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
	         }	
	 }
  }