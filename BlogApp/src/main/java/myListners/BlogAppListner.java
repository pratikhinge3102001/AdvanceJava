package myListners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class BlogAppListner implements ServletContextListener {
	
	Connection con;

	 public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		 try 
	    	{
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		String jdbcurl = "jdbc:mysql://localhost:3306/blogdb";
	    		con = DriverManager.getConnection(jdbcurl,"root","root");
	    		System.out.println("con is established");
	    		
	    		sce.getServletContext().setAttribute("jdbccon", con);
	    		System.out.println("cons set as context level attribute");
	    		
	    	}
	    	catch(Exception e) 
	    	{
	    		e.printStackTrace();
	    	}
		 
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	try 
    	{
    		con.close();
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }

	
   
	
}
