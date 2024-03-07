package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//get the response - header
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		
		//generating own response
		out.print("<h3> Hi user </h3>");
		
		//get the response - footer
		RequestDispatcher rd1 = request.getRequestDispatcher("/footer");
		rd1.include(request, response);
		
		
	}

}






