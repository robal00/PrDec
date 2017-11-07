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
    static char[] Password(int len)
    {
       
 
        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
                String symbols = "!@#$%^&*_=+-/.?)";
 
 
        String values = Capital_chars + Small_chars +
                        numbers + symbols;
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] password = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
              values.charAt(rndm_method.nextInt(values.length()));
            
 
        }
        return password;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int length = Integer.parseInt(request.getParameter("passLenght"));
   	 
   	 String s = String.valueOf(Password(length));
   	 
   	 HttpSession session = request.getSession(); 
   	 String m = (String)session.getAttribute("name");
   	 session.setAttribute("pswo", s);
   	 
   	RequestDispatcher dispatcher = request.getRequestDispatcher("generatedPassword.jsp");
   	dispatcher.forward(request, response);
   	/**
		PrintWriter out = response.getWriter();
		
		//out.println("</html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />");
		out.println("</head>");
		out.println("<body>");
		out.println("GENERATED PASSWORD: <br/>");
		out.println(s);
		out.println("<form action=\"register\" method=\"post\">");
		out.println("userName:<br/><input type=\"text\" name=\"userName\" value=");
		out.println(m);
		out.println("><br/>");
		out.println("app:<br/><input type=\"text\" name=\"app\" /><br/>");
		out.println("appPassword:<br/><input type=\"text\" name=\"appPassword\" value=");
		out.println(s);
		out.println("><br/>");
		out.println("<br/>");
		out.println("<input class=\"button\" type=\"submit\" value=\"Submit\"/>");
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		**/
	}
       // TODO Auto-generated constructor stub
   

	
	
	}
