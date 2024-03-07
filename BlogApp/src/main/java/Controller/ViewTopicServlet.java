package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

import Model.Topic;

@WebServlet("/getTopic")
public class ViewTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		if(con == null)
			System.out.println("null");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from topic");
			Topic topic = null;
			Set<Topic> topicset = new HashSet();
			
			while(rs.next()) 
			{
				int topicid = rs.getInt(1);
				String name = rs.getString(2);
				String desc = rs.getString(3);
				String uid = rs.getString(4);
				
				topic = new Topic(topicid,name,desc,uid);
				topicset.add(topic);
			}
			ServletContext context = getServletContext();
			
			context.setAttribute("topiclist", topicset);
			
			RequestDispatcher rd = request.getRequestDispatcher("/ShowTopic.jsp");
			rd.forward(request, response);
			
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
