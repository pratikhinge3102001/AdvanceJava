package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Address;
import beans.User;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		int age = Integer.parseInt(request.getParameter("age"));
		String area = request.getParameter("area");
		String city = request.getParameter("city");
		String pincode = request.getParameter("pincode");
		
		String [] hobbies= request.getParameterValues("hobbies");
		request.setAttribute("hobbylist", hobbies);	
				
		Address add = new Address(area,city,pincode);
		User user = new User(uid,pwd,fname,lname,email,contact,age,add);
		request.setAttribute("userinfo", user);
		
		Cookie cookie = new Cookie("uidcookie",uid);
		response.addCookie(cookie);
		
		RequestDispatcher rd = request.getRequestDispatcher("/el.jsp");
		rd.forward(request, response);
		
		
	}

}
