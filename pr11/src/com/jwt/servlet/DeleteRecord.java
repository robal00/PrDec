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
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String n = request.getParameter("userName");
        String p = request.getParameter("app");
        
        
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database1", "root", "kamilr00");
 
            PreparedStatement ps = con
                    .prepareStatement("DELETE from data WHERE userName=? and app=?;");                   		;
 
           ps.setString(1, n);
           ps.setString(2, p);
          
            
 
            int i = ps.executeUpdate();
            if (i > 0) {
            

           
            out.print("<p style=\"color:green\">password deleted</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("pro.jsp");  
            rd.include(request,response);  }
            
            else{  
                out.print("<p style=\"color:red\">Something went wrong</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("pro.jsp");  
                rd.include(request,response);  
            }  
 
        } catch (Exception e2) {
        	RequestDispatcher rd=request.getRequestDispatcher("error.html");  
            rd.include(request,response); 
        }
 
        out.close();
    }
 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
