package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Actual business logic
		PrintWriter out = response.getWriter();

		// read request parameters
		String u = request.getParameter("uid");
		String p = request.getParameter("pwd");
		String fn = request.getParameter("fname");
		String mn = request.getParameter("mname");
		String ln = request.getParameter("lname");
		String eml = request.getParameter("eml");
		String cnt = request.getParameter("contact");
		// jdbc
		PreparedStatement ps = null;
		int rs=0;

		try {
			ps = con.prepareStatement("insert into users(u_id,password,fname,mname,lname,email,contact) values(?,?,?,?,?,?,?)");
			ps.setString(1, u);
			ps.setString(2, p);
			ps.setString(3,fn);
			ps.setString(4,mn);
			ps.setString(5,ln);
			ps.setString(6,eml);
			ps.setString(7,cnt);
			rs = ps.executeUpdate();
			

			if (rs>0) {
//				out.print("<h1> Record Inserted Successfully...! </h1>");
				response.sendRedirect("/ShoppingApp/login.jsp");
			}
			else if(rs==0) {
				out.print("<h1> Record not Inserted Successfully...! </h1>");
				response.sendRedirect("/ShoppingApp/register.jsp");
//				response.sendRedirect("/SecondWeb/login.html");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}