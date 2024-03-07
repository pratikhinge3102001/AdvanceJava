package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 {

	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
	
		
		try
		{
			//step 1
			//loading driver class in memory
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2
			String jdbcurl = "jdbc:mysql://localhost:3306/jdbc";
			con = DriverManager.getConnection(jdbcurl,"root","root");
			System.out.println("Connection established");
			
			//step 3
			//empty object - holding SQL query
			stmt = con.createStatement();
			
			int n = stmt.executeUpdate("update emp set sal = 5000 where empno = 7566");
			System.out.println(n + " records updated");
			
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("driver class not loaded");
		}
		catch(SQLException e)
		{
			System.out.println("Connection rejected");
		}
		finally
		{
			
			try
			{
				
				stmt.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
