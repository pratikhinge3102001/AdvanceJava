package userservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitcount")
public class VisitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int n = 0;
		Cookie [] all = request.getCookies();
		if(all != null)
		{
			for(Cookie c : all)
			{
				if(c.getName().equals("visitcountcookie"))
				{
					n = Integer.parseInt(c.getValue());
				}
			}
		}
		
		n++;
		Cookie cookie = new Cookie("visitcountcookie", ""+n);
		response.addCookie(cookie);
		out.print("<br/> Visit count : "+n);
		out.print("<br/><a href='visitcount'> REFRESH </a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
