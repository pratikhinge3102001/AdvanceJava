package listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ShoppingAppListener implements ServletContextListener {

	Connection con;
	public void contextInitialized(ServletContextEvent sce)  { 
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String jdbcurl = "jdbc:mysql://localhost:3306/shoppingdb";
        	con = DriverManager.getConnection(jdbcurl, "root", "root");
        	System.out.println("con established");
        	sce.getServletContext().setAttribute("jdbccon", con);
        	System.out.println("con set as context level attribute");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
         try
         {
        	 con.close();
         }
         catch(Exception e)
         {
         	e.printStackTrace();
         }
         
    }

    
	
}
