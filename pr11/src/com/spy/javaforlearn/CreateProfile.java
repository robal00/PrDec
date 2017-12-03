/*Class name: CreateProfile.java
 * date: 15/11/2017
 * @reference:  //http://javaforlearn.com/servlet-to-create-user-profile/
 * @reference: https://stackoverflow.com/questions/3864903/how-do-you-enforce-password-complexity-rules-in-zotonic
 * @author: Kamil Robakowski 16138520
 * @comments: Parts of code in this class have been reused and sourced from website referenced.
 * author modified:
 * parameters required to connect to database to match development environment requirements
 * messages to be sent in responses
 * prepared statement for query to be executed in database
 * exception handling (redirect to error page instead of printing stack trace)
 * code comments 
 * author added:
 * validation of strings n and p 
 * GET method
*/
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

public class CreateProfile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

	{
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		// receive strings from form in jsp
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		// validate if there user name is in email format and password matches policy
		if (p.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$")
				&& n.matches("\\w+@\\w+\\.\\w+")) {

			Connection con = null;
			PreparedStatement pstmt = null;

			ResultSet rs = null;

			try {
				// 1. Load the Driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				// 2. Get the DB Connection via Driver
				String dbUrl = "jdbc:mysql://localhost:3306/database1?user=dbUser&password=zaq1@wsx";
				con = DriverManager.getConnection(dbUrl);

				// 3. Issue SQL Queries via Connection
				String query = "insert into users values(?,?) ";

				pstmt = con.prepareStatement(query);
				pstmt.setString(1, n);
				pstmt.setString(2, p);
				int count = pstmt.executeUpdate();

				if (count > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					out.print("Thanks for Sign up, Your profile successfully created");
					rd.include(request, response);
				}
			}

			catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				out.print("Something went wrong, Please try again");
				rd.include(request, response);
			}

			finally {
				// 5. Close all JDBC Objects
				try {
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					// if exception occurs redirect to error page
					RequestDispatcher rd = request.getRequestDispatcher("error.html");
					rd.include(request, response);
				}

			}
		} else {
			//if validation of user name or password fails redirect back to create profile page with error message 
			RequestDispatcher rd = request.getRequestDispatcher("Createprofile.jsp");
			out.print("incorrect password or user name format");
			rd.include(request, response);
		}
	}

	// redirect to index.jsp if GET method is called
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("index.jsp").include(request, response);
	}
}