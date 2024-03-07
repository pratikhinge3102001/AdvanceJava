/*package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		PreparedStatement ps = null;
		int res=0;
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			
			try {
				String uid = ((User)session.getAttribute("loggedinuser")).getUid();
				System.out.println(uid);
				Timestamp cdate = new Timestamp(new Date().getTime());
				System.out.println(cdate);
				ps = con.prepareStatement("update loginfo set logout=? where u_id=? and logout is null");
				ps.setTimestamp(1, cdate);
				ps.setString(2, uid);
				res = ps.executeUpdate();
				
				System.out.println(res);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			session.invalidate();
			out.print("<br/> You are logged out successfully ");
			out.print("<br/> <a href='login.jsp'> Login again? </a> ");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}*/


package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection con;

    public void init(ServletConfig config) throws ServletException {
        con = (Connection) config.getServletContext().getAttribute("jdbccon");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PreparedStatement ps = null;
        int res = 0;
        HttpSession session = request.getSession(false);

        if (session != null) {
            try {
                String uid = ((User) session.getAttribute("loggedinuser")).getUid();
                Timestamp cdate = new Timestamp(new Date().getTime());

                // Use ORDER BY and LIMIT 1 to get the last row
                ps = con.prepareStatement(
                        "UPDATE loginfo SET logout = ? WHERE u_id = ? AND logout IS NULL ORDER BY logid DESC LIMIT 1");
                ps.setTimestamp(1, cdate);
                ps.setString(2, uid);
                res = ps.executeUpdate();

                System.out.println(res);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.invalidate();
            out.print("<br/> You are logged out successfully ");
            out.print("<br/> <a href='login.jsp'> Login again? </a> ");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}



