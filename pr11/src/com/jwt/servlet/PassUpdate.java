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
 * Servlet implementation class Updater
 */
@WebServlet("/PassUpdate")
public class PassUpdate extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
 
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database1", "root", "kamilr00");
 
            PreparedStatement ps = con
                    .prepareStatement("UPDATE users SET pass=? WHERE userName=? ;");                   		;
 
           ps.setString(1, p);
           ps.setString(2, n);
           
            
 
            int i = ps.executeUpdate();
            if (i > 0) {
            

           
            out.print("<p style=\"color:green\">password updated</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("pro.jsp");  
            rd.include(request,response);  }
           
            else{  
                out.print("<p style=\"color:red\">Something went wrong</p>");  
                RequestDispatcher rd=request.getRequestDispatcher("pro.jsp");  
                rd.include(request,response);  
            }  
            
 
        } catch (Exception e2) {
            System.out.println(e2);
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
