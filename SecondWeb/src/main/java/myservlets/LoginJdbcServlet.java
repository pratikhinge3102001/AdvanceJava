package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginjdbc")
public class LoginJdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl = "jdbc:mysql://localhost:3306/shoppingdb";
			con = DriverManager.getConnection(jdbcurl, "root", "root");
			System.out.println("con established");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		try
		{
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actual business logic
		PrintWriter out = response.getWriter();
		
		//read request parameters
		String u = request.getParameter("uid");
		String p= request.getParameter("pwd");
		
		//jdbc
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
			ps.setString(1, u);
			ps.setString(2, p);
			rs = ps.executeQuery();
			/*if(rs.next())
			{				
			}
			else
			{				
			}*/
			boolean flag = false;
			while(rs.next())
			{
				if(rs.getString(1).equals(u) && rs.getString(2).equals(p))
				{
					flag = true;
					break;
				}
			}
			if(flag)//success
			{
				//out.print("<h1> Success Login </h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/home");
				rd.forward(request, response);
			}
			else //failed
			{
				//out.print("<h1> Failed Login </h1>");
				response.sendRedirect("/SecondWeb/login.html");
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







