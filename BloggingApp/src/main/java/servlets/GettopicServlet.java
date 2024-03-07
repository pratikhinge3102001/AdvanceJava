package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import beans.Topic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Topic;

/**
 * Servlet implementation class getTopicsServlet
 */
@WebServlet("/gettopics")
public class GettopicServlet extends HttpServlet {
	
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from topic");
			Topic topic = null;
			Set<Topic> topicset = new HashSet();	//take it in hashset using set for avoid duplicate entries
			
			while(rs.next())
			{
				int topicid = rs.getInt(1);
				String name = rs.getString(2);
				String desc = rs.getString(3);
				String uid = rs.getString(4);
				
				topic = new Topic(topicid,name,desc,uid);	//contructor of topic class topicid name desc uid added from DB
				topicset.add(topic);	//topic object added into the set name as topicset
				
			}
			
			ServletContext context = getServletContext();
			
			context.setAttribute("topiclist", context);	////setting context level attribute as name topic list and set it as context level to make it accessible trough out the application 
			
			RequestDispatcher rd = request.getRequestDispatcher("/gettopics.jsp");	//now dispatching the request to the getTopic.jsp to show info of DB on the browser
			rd.forward(request, response);	//forwarding the dispatcher request as forward type
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();;
			}
		}
	}

}