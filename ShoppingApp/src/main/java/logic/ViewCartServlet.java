package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/viewcart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		List<Integer> plist = null;
		plist =(List) session.getAttribute("cart");
		if(plist == null)
		{
			out.print("<h2> Cart is empty </h2>");
			out.print("<br/> <a href='home'> Go back for selection </a>");
		}
		else
		{
			/*out.print("<ul>");
			for(int n : plist)
			{
				out.print("<li>"+n+"</li>");
			}
			out.print("</ul>");*/
			out.print("<table border=1>");
			PreparedStatement ps = null;
			ResultSet rs = null;
			try
			{
				int count = 0;
				float total = 0;
				for(int n : plist)
				{
					ps = con.prepareStatement("select * from product where p_id = ?");
					ps.setInt(1, n);
					rs = ps.executeQuery();
					rs.next();
					out.print("<tr>");
					out.print("<td>"+ (++count) + "</td>");
					out.print("<td>"+ rs.getString(2) + "</td>");
					out.print("<td>"+ rs.getFloat(4) + "</td>");
					out.print("</tr>");
					total += rs.getFloat(4);
				}
				out.print("<tr>");
				out.print("<td colspan='2'> Total price </td>");
				out.print("<td>"+total+"</td>");
				out.print("</tr>");
				out.print("</table>");
				//
				session.setAttribute("tprice", total );
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					rs.close();
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			out.print("<br/> <a href='home'> Go back for selection </a>");
			out.print("<br/> <a href='confirmcart'> Confirm cart </a>");
			
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
