/*Class name: PassUpdate.java
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
 * code comments 
 * GET method
*/

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// receive strings from form in jsp
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");

		try {
			
			// connecting to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "dbUser", "zaq1@wsx");
			// prepared statement for query to be executed in database
			PreparedStatement ps = con.prepareStatement("UPDATE users SET pass=? WHERE userName=? ;");
			;
			
			ps.setString(1, p);
			ps.setString(2, n);
			// execution of query in database
			int i = ps.executeUpdate();
			if (i > 0) {
				// if query executed successfully redirect to pro.jsp and display message
				out.print("<p style=\"color:green\">password updated</p>");
				RequestDispatcher rd = request.getRequestDispatcher("pro.jsp");
				rd.include(request, response);
			}

			else {
				// if query returns error redirect back to profile page with error message
				out.print("<p style=\"color:red\">Something went wrong</p>");
				RequestDispatcher rd = request.getRequestDispatcher("pro.jsp");
				rd.include(request, response);
			}

		} catch (Exception e2) {
			// if exception occurs redirect to error page
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.include(request, response);
			;
		}

		out.close();
	}

	// redirect to index.jsp if GET method is called
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("index.jsp").include(request, response);
	}

}
