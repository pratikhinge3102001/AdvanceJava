package myservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logincheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u = request.getParameter("uid");
		String p= request.getParameter("pwd");
		String c = request.getParameter("color");

		if(u.equals("object") && p.equals("object123"))
			out.print("<h2 style='color:"+c+"'> Login was successfull! </h2>");

		else
			out.print("<h2> Login failed </h2>");
			
	}

}