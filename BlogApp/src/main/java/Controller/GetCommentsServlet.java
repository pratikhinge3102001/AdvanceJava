package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Comment;



@WebServlet("/getComments")
public class GetCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		int tid = Integer.parseInt(request.getParameter("topicid"));
		try 
		{
			ps = con.prepareStatement("select * from comments where topicid = ?");
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			Comment comments = null;
			Set<Comment> clist = new HashSet<Comment>();
			
			while(rs.next()) {
				
				int cid = rs.getInt(1);
				String text = rs.getString(2);
				int topicid = rs.getInt(3);
				String uid = rs.getString(4);
				
				comments = new Comment(cid,topicid,text,uid);
				clist.add(comments);
				
				ServletContext context = getServletContext();
				
				context.setAttribute("commentlist", clist);
				
				RequestDispatcher rd = request.getRequestDispatcher("/showComments.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
