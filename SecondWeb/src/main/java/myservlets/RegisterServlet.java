package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/registerJDBC")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	
	   public void init(ServletConfig config) throws ServletException
	   {
		   super.init(config);
		   try 
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   String jdbcurl = "jdbc:mysql://localhost:3306/shoppingdb";
			   con = DriverManager.getConnection(jdbcurl,"root","root");
			   System.out.println("con established");
			   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
		
	   public void destroy()
	   {
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
			doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actually business logic
		PrintWriter out = response.getWriter();

		//read request paramters
		String u = request.getParameter("uid");
		String p = request.getParameter("pwd");
		String fname = request.getParameter("fn");
		String mname = request.getParameter("mn");
		String lname = request.getParameter("ln");
		String email = request.getParameter("eml");
		String cont = request.getParameter("cnt");
		
		System.out.println(u);
		//jdbc
		PreparedStatement ps = null;
		int rs = 0;
		try
		{
			ps = con.prepareStatement("insert into users(u_id,password,fname,mname,lname,email,contact) values(?,?,?,?,?,?,?)");	//name must matches with db names
			ps.setString(1,u);
			ps.setString(2, p);
			ps.setString(3,fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6,email);
			ps.setString(7, cont);
			rs = ps.executeUpdate();//gives count of update/affected rows
			
			if(rs>0)
			{
				
				//out.print("<h1> registered successfull </h1>");
				response.sendRedirect("/SecondWeb/login.html");
				
				
			}
			else
			{
				
				
				response.sendRedirect("/SecondWeb/register.html");
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}