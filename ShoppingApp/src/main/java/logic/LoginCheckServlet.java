package logic;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/logincheck")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		//read request parameters
		String u = request.getParameter("uid");
		String p= request.getParameter("pwd");
		
		//jdbc
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		boolean flag= false;
		Date date = new Date();
		Timestamp ts= new Timestamp(date.getTime());
		try
		{
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
			ps1= con.prepareStatement("insert into loginfo(u_id,login)values(?,?)");
			ps.setString(1, u);
			ps.setString(2, p);
			ps1.setString(1,u);
			ps1.setTimestamp(2, ts);
			rs = ps.executeQuery();
			User user = null;
			
			while(rs.next())
			{
				if(rs.getString(1).equals(u) && rs.getString(2).equals(p))
				{
					flag = true;
					ps1.executeUpdate();
					user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					
					break;
				}
			}
			if(flag)//success
			{
				//out.print("<h1> Success Login </h1>");
				//if cookie present delete it
				Cookie [] all = request.getCookies();
				if(all != null)
				{
					for(Cookie c : all)
					{
						if(c.getName().equals("loginerror"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				}
				
				HttpSession session = request.getSession();
				session.setAttribute("loggedinuser", user);		
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
			}
			else //failed
			{
				//out.print("<h1> Failed Login </h1>");
				//create cookie
				Cookie c = new Cookie("loginerror","Wrong_UID/pwd");
				response.addCookie(c);
				response.sendRedirect("/ShoppingApp/login.jsp");
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				rs.close();
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}		
	}

}
