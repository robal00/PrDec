/*Class name: Generator.java
 * date: 15/11/2017
 * @reference:  http://www.geeksforgeeks.org/generating-password-otp-java/ 
 * @author: Kamil Robakowski 16138520
 * @comments: Password method of this class has been created by reusing of code available at referenced website.
 * author created GET and POST methods for this servlet
*/

package generating;

import java.io.IOException;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Generator2
 */
@WebServlet("/Generator2")
public class Generator2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Generator2() {
		super();
		// TODO Auto-generated constructor stub
	}

	// This our Password generating method
	// We have use static here, so that we not to
	// make any object for it
	static char[] Password(int len) {

		// A strong password has Cap_chars, Lower_chars,
		// numeric value and symbols. So we are using all of
		// them to generate our password
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		// Using random method
		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return password;
	}
	//redirect to index.jsp if GET method is called
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("index.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//receive length of password from form in JSP file
		int length = Integer.parseInt(request.getParameter("passLenght"));

		//generate new random password of length provided using "Password" method
		String s = String.valueOf(Password(length));
		//set session parameter "pswo", string generated in Password method.
		HttpSession session = request.getSession();
		String m = (String) session.getAttribute("name");
		session.setAttribute("pswo", s);

		//redirect to generatedPassword.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("generatedPassword.jsp");
		dispatcher.forward(request, response);

	}

}
