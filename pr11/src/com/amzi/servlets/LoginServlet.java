/*Class name: LoginServlet.java
 * date: 15/11/2017
 * @reference:  http://javaandj2eetutor.blogspot.ie/2014/01/login-application-using-jsp-servlet-and.html
 * @author: Kamil Robakowski 16138520
 * @comments: Parts of code in this class have been reused and sourced from blog referenced.
 * author modified:
 * parameters required to connect to database to match development environment requirements
 * messages to be sent in responses
 * author added:
 * validation of strings n and p 
 * code comments 
 * GET method
*/

package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzi.dao.LoginDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// receive strings from form in jsp
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");

		// validate if there are no spaces in strings p and n
		if (p.matches("\\w*\\s+\\w*") || n.matches("\\w*\\s+\\w*"))

		{
			// redirect back to login.jsp if there is space in either p or n with error message
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.print("Sorry username or password error");
			rd.include(request, response);
		} else {

			
			HttpSession session = request.getSession(false);
			//establish session with attribute n if LoginDao.java class returns true
			if (session != null)
				session.setAttribute("name", n);

			if (LoginDao.validate(n, p)) {
				RequestDispatcher rd = request.getRequestDispatcher("pro.jsp");
				rd.forward(request, response);
			} else {
				
			//if LoginDao.java return false, redirect back to index.jsp with error message	
				out.print("<p style=\"color:red\">Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}

			out.close();
		}
	}
	//redirect to index.jsp if GET method is called
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
}
